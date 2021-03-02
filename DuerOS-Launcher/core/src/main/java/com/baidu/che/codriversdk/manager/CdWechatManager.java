//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.WechatCommandHandler;

public class CdWechatManager implements INoProguard {
    public static final String WECHAT_TOOL = "wechat.tool";

    public CdWechatManager() {
    }

    private static class CdWechatManagerHolder {
        private static CdWechatManager instance = new CdWechatManager();
    }

    public static CdWechatManager getInstance() {
        return CdWechatManagerHolder.instance;
    }

    public void setWXTool(CdWechatManager.WechatTool tool) {
        RequestManager.getInstance().sendRequest(WECHAT_TOOL, "set", (String)null);
        RequestManager.getInstance().addCommandHandler(WECHAT_TOOL, new WechatCommandHandler(tool));
    }

    public interface WechatTool extends INoProguard {
        void sendMessage(String var1);
    }
}
