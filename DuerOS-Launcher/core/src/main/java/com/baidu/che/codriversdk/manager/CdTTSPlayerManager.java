package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.TTSPlayerHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class CdTTSPlayerManager implements INoProguard {

    public static final String TAG = "CdTTSPlayerManager";
    public static final String TTS_TOOL = "tts.tool";

    private TTSPlayerHandler mTTSPlayHandler = new TTSPlayerHandler();

    public CdTTSPlayerManager() {
        RequestManager.getInstance().addCommandHandler(TTS_TOOL, this.mTTSPlayHandler);
    }

    public static CdTTSPlayerManager getInstance() {
        return CdTTSPlayerManager.a.a;
    }

    public void setTTSPlayerListener(CdTTSPlayerManager.TTSPlayerListener listener) {
        this.mTTSPlayHandler.setPlayerListener(listener);
        RequestManager.getInstance().sendRequest(TTS_TOOL, "set", (String)null);
    }

    public void setTTSPlayStatusListener(CdTTSPlayerManager.TTSPlayStatusListener listener) {
        this.mTTSPlayHandler.setPlayerStatusListener(listener);
    }

    public void playAndShow(String text, CdTTSPlayerManager.PlayAndShowListener listener) {
        this.mTTSPlayHandler.setPlayerAndShowListener(listener);
        RequestManager.getInstance().sendRequest(TTS_TOOL, "play_and_show_with_cb", text);
    }

    public void play(String text) {
        RequestManager.getInstance().sendRequest(TTS_TOOL, "play", text);
    }

    public void playWithUtteranceId(String text, String utteranceId) {
        if (text != null && !text.isEmpty()) {
            if (utteranceId == null) {
                this.play(text);
            } else {
                JSONObject sendData = new JSONObject();

                try {
                    sendData.put("id", utteranceId);
                    sendData.put("text", text);
                    RequestManager.getInstance().sendRequest(TTS_TOOL, "play_with_id", sendData.toString());
                } catch (JSONException var5) {
                    var5.printStackTrace();
                }

            }
        }
    }

    public void playAndShow(String text) {
        RequestManager.getInstance().sendRequest(TTS_TOOL, "play_and_show", text);
    }

    public void stop() {
        RequestManager.getInstance().sendRequest(TTS_TOOL, "stop", (String)null);
    }

    public void switchSpeak(CdTTSPlayerManager.SpeechType type) {
        this.switchType(type);
    }

    public void setAudioStreamType(int mType) {
        RequestManager.getInstance().sendRequest(TTS_TOOL, "set_stream_type", "" + mType);
    }

    private void switchType(CdTTSPlayerManager.SpeechType type) {
        String mType = "";
        if (type == CdTTSPlayerManager.SpeechType.EMOTION_FEMALE) {
            mType = "emotionfemale";
        } else if (type == CdTTSPlayerManager.SpeechType.EMOTION_MALE) {
            mType = "emotionmale";
        } else if (type == CdTTSPlayerManager.SpeechType.NORMAL_FEMALE) {
            mType = "nomalfemale";
        } else if (type == CdTTSPlayerManager.SpeechType.NORMAL_MALE) {
            mType = "nomalmale";
        } else if (type == CdTTSPlayerManager.SpeechType.EMOTION_DUXIAOJIAO_FEMALE) {
            mType = "duxiaojiaofemale";
        } else {
            mType = "nomalfemale";
        }

        RequestManager.getInstance().sendRequest(TTS_TOOL, "switch", mType);
    }

    public static enum SpeechType implements INoProguard {
        NORMAL_FEMALE,
        EMOTION_FEMALE,
        NORMAL_MALE,
        EMOTION_MALE,
        EMOTION_DUXIAOJIAO_FEMALE;

        private SpeechType() {
        }
    }

    public interface TTSPlayStatusListener extends INoProguard {
        void onPlayStart(String var1);

        void onPlayFinish(String var1);

        void onPlayInterrupt(String var1);

        void onPlayBusy(String var1);

        void onPlayError(String var1);
    }

    public interface TTSPlayerListener extends INoProguard {
        void onSpeechStart(String var1);

        void onSpeechFinish(String var1);

        void onError(String var1);
    }

    public interface PlayAndShowListener extends INoProguard {
        void onVrDismiss();
    }

    private static class a {
        private static CdTTSPlayerManager a = new CdTTSPlayerManager();
    }
}
