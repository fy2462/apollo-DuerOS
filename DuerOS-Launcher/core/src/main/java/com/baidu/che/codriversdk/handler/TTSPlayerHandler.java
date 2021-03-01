package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdTTSPlayerManager.PlayAndShowListener;
import com.baidu.che.codriversdk.manager.CdTTSPlayerManager.TTSPlayStatusListener;
import com.baidu.che.codriversdk.manager.CdTTSPlayerManager.TTSPlayerListener;

public class TTSPlayerHandler implements ICmdHandler {
    private TTSPlayerListener mPlayerListener;
    private TTSPlayStatusListener mPlayerStatusListener;
    private PlayAndShowListener mPlayerAndShowListener;

    public TTSPlayerHandler() {
    }

    public void setPlayerListener(TTSPlayerListener ttsPlayerListener) {
        this.mPlayerListener = ttsPlayerListener;
    }

    public void setPlayerStatusListener(TTSPlayStatusListener ttsPlayStatusListener) {
        this.mPlayerStatusListener = ttsPlayStatusListener;
    }

    public void setPlayerAndShowListener(PlayAndShowListener playAndShowListener) {
        this.mPlayerAndShowListener = playAndShowListener;
    }

    public String handle(String cmd, String param, String data) {
        LogUtil.e("TTSPlayerHandler", "onCommand " + cmd + " " + param);
        if ("tts.tool".equals(cmd)) {
            if ("onPlayStart".equals(param)) {
                if (this.mPlayerStatusListener != null) {
                    this.mPlayerStatusListener.onPlayStart(data);
                }
            } else if ("onPlayFinish".equals(param)) {
                if (this.mPlayerStatusListener != null) {
                    this.mPlayerStatusListener.onPlayFinish(data);
                }
            } else if ("onPlayInterrupt".equals(param)) {
                if (this.mPlayerStatusListener != null) {
                    this.mPlayerStatusListener.onPlayInterrupt(data);
                }
            } else if ("onPlayBusy".equals(param)) {
                if (this.mPlayerStatusListener != null) {
                    this.mPlayerStatusListener.onPlayBusy(data);
                }
            } else if ("onPlayError".equals(param)) {
                if (this.mPlayerStatusListener != null) {
                    this.mPlayerStatusListener.onPlayError(data);
                }
            } else if ("onVrDismiss".equals(param)) {
                if (this.mPlayerAndShowListener != null) {
                    this.mPlayerAndShowListener.onVrDismiss();
                    this.mPlayerAndShowListener = null;
                }
            } else if ("onSpeechStart".equals(param)) {
                if (this.mPlayerListener != null) {
                    this.mPlayerListener.onSpeechStart(data);
                }
            } else if ("onSpeechFinish".equals(param)) {
                if (this.mPlayerListener != null) {
                    this.mPlayerListener.onSpeechFinish(data);
                }
            } else if ("onError".equals(param) && this.mPlayerListener != null) {
                this.mPlayerListener.onError(data);
            }
        }

        return null;
    }
}
