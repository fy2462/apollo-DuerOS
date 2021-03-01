package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdPrivateRadioManager.PrivateRadioModel;
import com.baidu.che.codriversdk.manager.CdPrivateRadioManager.PrivateRadioTool;
import com.google.gson.Gson;

public class RadioHandler implements ICmdHandler {
    private PrivateRadioTool tool;

    public RadioHandler(PrivateRadioTool tool) {
        this.tool = tool;
    }

    public String handle(String cmd, String param, String data) {
        if (this.tool == null) {
            return null;
        } else {
            if ("private_radio.tool".equals(cmd) && "open".equals(param)) {
                PrivateRadioModel model = (PrivateRadioModel)(new Gson()).fromJson(data, PrivateRadioModel.class);
                this.tool.openPrivateRadio(model);
            }

            return null;
        }
    }
}
