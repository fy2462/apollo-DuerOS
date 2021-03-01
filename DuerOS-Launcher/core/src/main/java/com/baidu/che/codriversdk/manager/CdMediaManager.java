package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.MediaCommandHandler;

public class CdMediaManager implements INoProguard {
    public static final String MEDIA_TOOL = "media.tool";

    public CdMediaManager() {
    }

    private static class CdMediaManagerHolder {
        private static CdMediaManager instance = new CdMediaManager();
    }

    public static CdMediaManager getInstance() {
        return CdMediaManagerHolder.instance;
    }

    public void setMediaTool(CdMediaManager.MediaTool tool) {
        RequestManager.getInstance().sendRequest("media.tool", "set", (String)null);
        RequestManager.getInstance().addCommandHandler("media.tool", new MediaCommandHandler(tool));
    }

    public void sendMediaRequest(String param, String data) {
        RequestManager.getInstance().sendRequest("media.tool", param, data);
    }

    public interface MediaTool extends INoProguard {
        void openRadio();

        void closeRadio();

        void openFM();

        void openFMChannel(String var1);

        void openAM();

        void openAMChannel(String var1);

        void openMusicUsb();

        void openMusicCd();

        void openMusicAux();

        void openMusicIpod();

        void openMusicBt();

        void openMyMusic();
    }
}
