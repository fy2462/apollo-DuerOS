package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.MusicCommandHandler;
import java.util.List;

public class CdMusicManager implements INoProguard {
    public CdMusicManager() {
    }

    public static CdMusicManager getInstance() {
        return CdMusicManagerHolder.instance;
    }

    private static class CdMusicManagerHolder {
        private static CdMusicManager instance = new CdMusicManager();
    }

    public void setMusicTool(CdMusicManager.MusicTool tool) {
        RequestManager.getInstance().sendRequest("music.tool", "set", (String)null);
        RequestManager.getInstance().addCommandHandler("music.tool", new MusicCommandHandler(tool));
    }

    public void sendRequest(String param, String data) {
        RequestManager.getInstance().sendRequest("music.tool", param, data);
    }

    public static class MusicModel implements INoProguard {
        public String name;
        public String albumName;
        public String albumArtistName;
        public String tag;
        public String type;
        public String rawJsonResult;

        public MusicModel() {
        }

        public String toString() {
            return "[name=" + this.name + " albumName=" + this.albumName + " albumArtistName=" + this.albumArtistName + " tag=" + this.tag + " type=" + this.type + "]";
        }
    }

    public interface OnSearchResultListener extends INoProguard {
        void onSuccess(List<CdMusicManager.MusicModel> var1);

        void onFail(String var1);
    }

    public interface MusicTool extends INoProguard {
        void playMusic(CdMusicManager.MusicModel var1);

        void playList(List<CdMusicManager.MusicModel> var1, int var2);

        void searchMusic(CdMusicManager.MusicModel var1, CdMusicManager.OnSearchResultListener var2);
    }

}
