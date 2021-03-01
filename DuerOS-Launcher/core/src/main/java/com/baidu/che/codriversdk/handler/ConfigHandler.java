package com.baidu.che.codriversdk.handler;

import android.os.Process;
import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;

public class ConfigHandler implements ICmdHandler {
    public ConfigHandler() {
    }

    public String handle(String cmd, String param, String data) {
        if ("config.tool".equals(cmd) && "notify_system_sleep".equals(param) && !RequestManager.getInstance().isSystemSleep()) {
            LogUtil.d("ConfigHandler", "onReceiveCommand-cmdType:" + cmd + ";param:" + param);
            int pid = Process.myPid();
            Process.killProcess(pid);
        }

        return null;
    }
}
