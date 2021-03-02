package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdMusicManager;
import com.google.gson.Gson;
import java.util.List;

public class MusicCommandHandler implements ICmdHandler {
    private CdMusicManager.MusicTool tool;

    public MusicCommandHandler(CdMusicManager.MusicTool musicTool) {
        this.tool = musicTool;
    }

    public String handle(String cmd, String param, String data) {
        if (this.tool == null)
            return null;
        if (CdMusicManager.MUSIC_TOOL.equals(cmd))
            if ("play.music".equals(param)) {
                CdMusicManager.MusicModel musicModel = new Gson().fromJson(data, CdMusicManager.MusicModel.class);
                this.tool.playMusic(musicModel);
            } else if ("play.list".equals(param)) {
                PlayList playList = new Gson().fromJson(data, PlayList.class);
                this.tool.playList(playList.list, playList.position);
            } else if ("search".equals(param)) {
                CdMusicManager.MusicModel musicModel = new Gson().fromJson(data, CdMusicManager.MusicModel.class);
                this.tool.searchMusic(musicModel, new CdMusicManager.OnSearchResultListener() {
                    public void onSuccess(List<CdMusicManager.MusicModel> musicList) {
                        MusicCommandHandler.PlayList playList = new MusicCommandHandler.PlayList(musicList, 0);
                        String result = (new Gson()).toJson(playList);
                        CdMusicManager.getInstance().sendRequest("search", result);
                    }

                    public void onFail(String error) {
                        CdMusicManager.getInstance().sendRequest("search", null);
                    }
                });
            }
        return null;
    }

    static class PlayList implements INoProguard {
        int position;

        List<CdMusicManager.MusicModel> list;

        public PlayList(List<CdMusicManager.MusicModel> list, int position) {
            this.list = list;
            this.position = position;
        }
    }
}
