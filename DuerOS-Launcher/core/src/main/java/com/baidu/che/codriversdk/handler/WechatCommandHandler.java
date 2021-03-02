package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdWechatManager;
import com.baidu.che.codriversdk.manager.CdWechatManager.WechatTool;

public class WechatCommandHandler implements ICmdHandler {

    private static final String TAG = WechatCommandHandler.class.getSimpleName();

    private WechatTool tool;

    public WechatCommandHandler(WechatTool tool) {
        this.tool = tool;
    }

    public String handle(String cmd, String param, String data) {
        LogUtil.d(TAG, "onReceiveCommand-cmdType:" + cmd + ";param:" + param);
        if (CdWechatManager.WECHAT_TOOL.equals(cmd) && this.tool != null && param.equals("send_message")) {
            this.tool.sendMessage(data);
        }

        return null;
    }
}
