package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.manager.CdAsrManager;
import com.baidu.che.codriversdk.manager.CdAsrManager.AsrTool;
import org.json.JSONException;
import org.json.JSONObject;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;

public class AsrControlHandler implements ICmdHandler  {
    private AsrTool tool;

    public AsrControlHandler() {
    }

    public void setAsrTool(AsrTool tool) {
        this.tool = tool;
    }

    public String handle(String cmd, String param, String data) {
        if ("asr.tool".equals(cmd)) {
            if ("register_cmd".equals(param)) {
                LogUtil.e("AsrControlHandler", "onCommand(): param=" + param + " data=" + data);

                try {
                    JSONObject dataObject = new JSONObject(data);
                    String cmdId = dataObject.optString("cmd_id");
                    JSONObject contentObject = dataObject.getJSONObject("cmd_content");
                    String cmdKey = contentObject.optString("cmd_key");
                    String cmdtext = contentObject.optString("cmd_text");
                    CdAsrManager.getInstance().onCommand(cmdId, cmdKey, cmdtext);
                } catch (JSONException var9) {
                    LogUtil.e("AsrControlHandler", var9.getMessage().toString());
                }
            } else if (this.tool == null) {
                LogUtil.e("AsrControlHandler", "---AsrTool is null!!!---");
            } else if ("dialog.show".equals(param)) {
                this.tool.onVrDialogShow();
            } else if ("dialog.dismiss".equals(param)) {
                this.tool.onVrDialogDismiss();
            }
        }

        return null;
    }
}
