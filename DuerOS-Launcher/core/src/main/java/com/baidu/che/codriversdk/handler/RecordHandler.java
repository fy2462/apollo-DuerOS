package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdRecordManager;
import com.baidu.che.codriversdk.manager.CdRecordManager.RecordTool;

public class RecordHandler implements ICmdHandler {
    RecordTool tool;

    public RecordHandler(RecordTool tool) {
        this.tool = tool;
    }

    public String handle(String cmd, String param, String data) {
        if (this.tool == null) {
            return null;
        }

        if (CdRecordManager.RECORD_TOOL.equals(cmd)) {
            if ("start_record".equals(param)) {
                this.tool.startRecord();
            } else if ("end_record".equals(param)) {
                this.tool.endRecord();
            } else if ("init_record".equals(param)) {
                this.tool.initRecorder();
            }
        }

        return null;
    }
}
