//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.RecordHandler;

public class CdRecordManager implements INoProguard {
    private static final String TAG = CdRecordManager.class.getSimpleName();

    public CdRecordManager() {
    }

    private static class CdRecordManagerHolder {
        private static CdRecordManager instance = new CdRecordManager();
    }

    public static CdRecordManager getInstance() {
        return CdRecordManagerHolder.instance;
    }

    public void setRecordTool(CdRecordManager.RecordTool tool) {
        RequestManager.getInstance().sendRequest("record.tool", "set", (String)null);
        RequestManager.getInstance().addCommandHandler("record.tool", new RecordHandler(tool));
    }

    public int feedAudioBuffer(byte[] micData, byte[] spkData) {
        return RequestManager.getInstance().feedAudioBuffer(micData, spkData);
    }

    public int feedRawAudioBuffer(byte[] rawData) {
        return RequestManager.getInstance().feedRawAudioBuffer(rawData);
    }

    public void setRecordType(CdRecordManager.RecordType recordType) {
        RequestManager.getInstance().sendRequest("record.tool", "record_type", "" + recordType.ordinal());
    }

    public interface RecordTool extends INoProguard {
        int RECORD_ERROR = -1;

        void startRecord();

        void endRecord();

        void initRecorder();
    }

    public static enum RecordType implements INoProguard {
        INSIDE_RAW,
        INSIDE_AEC_MIC_LEFT,
        INSIDE_AEC_MIC_RIGHT,
        OUTSIDE_RAW,
        OUTSIDE_AEC_MIC_LEFT,
        OUTSIDE_AEC_MIC_RIGHT,
        OUTSIDE_AEC_DUAL_CHANNEL;

        private RecordType() {
        }
    }

}
