package com.baidu.che.codriversdk.handler;

import android.os.Process;
import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdConfigManager;

public class ConfigHandler implements ICmdHandler {

    public static final String TAG = "ConfigHandler";

    public ConfigHandler() {
    }

    public String handle(String cmd, String param, String data) {
        if (CdConfigManager.CONFIG_TOOL.equals(cmd) && "notify_system_sleep".equals(param) && !RequestManager.getInstance().isSystemSleep()) {
            LogUtil.d(TAG, "onReceiveCommand-cmdType:" + cmd + ";param:" + param);
            int pid = Process.myPid();
            Process.killProcess(pid);
        }

        return null;
    }
}
