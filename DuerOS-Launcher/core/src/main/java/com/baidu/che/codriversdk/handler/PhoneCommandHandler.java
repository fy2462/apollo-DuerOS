package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdPhoneManager.PhoneTool;

public class PhoneCommandHandler implements ICmdHandler {
    private PhoneTool tool;

    public PhoneCommandHandler(PhoneTool tool) {
        this.tool = tool;
    }

    public String handle(String cmd, String param, String data) {
        LogUtil.e("PhoneCommandHandler", "onReceiveCommand-cmdType:" + cmd + ";param:" + param);
        if (this.tool == null) {
            return null;
        } else {
            if ("phone.tool".equals(cmd) && "call".equals(param)) {
                this.tool.dialNum(data);
            }

            return null;
        }
    }
}
