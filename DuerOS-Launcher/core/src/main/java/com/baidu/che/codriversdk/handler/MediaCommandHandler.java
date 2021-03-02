package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdMediaManager;
import com.baidu.che.codriversdk.manager.CdMediaManager.MediaTool;

public class MediaCommandHandler implements ICmdHandler {

    private static final String TAG = "MediaCommandHandler";
    private MediaTool tool;

    public MediaCommandHandler(MediaTool tool) {
        this.tool = tool;
    }

    public String handle(String cmd, String param, String data) {
        LogUtil.e(TAG, "onReceiveCommand-cmdType:" + cmd + ";param:" + param);
        if (this.tool == null || !CdMediaManager.MEDIA_TOOL.equals(cmd) || param == null) {
            return null;
        }

        if ("radio".equals(param)) {
            if ("close".equals(data)) {
                this.tool.closeRadio();
            } else {
                this.tool.openRadio();
            }
        } else if ("fm".equals(param)) {
            if (data == null) {
                this.tool.openFM();
            } else {
                this.tool.openFMChannel(data);
            }
        } else if ("am".equals(param)) {
            if (data == null) {
                this.tool.openAM();
            } else {
                this.tool.openAMChannel(data);
            }
        } else if ("usb".equals(param)) {
            this.tool.openMusicUsb();
        } else if ("cd".equals(param)) {
            this.tool.openMusicCd();
        } else if ("aux".equals(param)) {
            this.tool.openMusicAux();
        } else if ("ipod".equals(param)) {
            this.tool.openMusicIpod();
        } else if ("bt".equals(param)) {
            this.tool.openMusicBt();
        } else if ("mymusic".equals(param)) {
            this.tool.openMyMusic();
        }

        return null;
    }
}
