package com.baidu.che.codriversdk.handler;

import android.view.KeyEvent;
import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdHardKeyManager;
import com.baidu.che.codriversdk.manager.CdHardKeyManager.HardKeyTool;

public class HardKeyHandler implements ICmdHandler {

    public static final String TAG = "HardKeyHandler";

    private HardKeyTool tool;

    public HardKeyHandler(HardKeyTool tool) {
        this.tool = tool;
    }

    public String handle(String cmd, String param, String data) {
        LogUtil.e(TAG, "onReceiveCommand-cmdType:" + cmd + ";param:" + param);
        if (this.tool == null) {
            return null;
        } else if (!CdHardKeyManager.HARDKEY_TOOL.equals(cmd)) {
            return null;
        } else if (param == null) {
            return null;
        } else {
            if ("up".equals(param)) {
                this.tool.onKeyUp(Integer.parseInt(data), (KeyEvent)null);
            } else if ("down".equals(param)) {
                this.tool.onKeyDown(Integer.parseInt(data), (KeyEvent)null);
            } else if ("click".equals(param)) {
                this.tool.onSingleClick(Integer.parseInt(data));
            } else if ("long_click".equals(param)) {
                this.tool.onLongClick(Integer.parseInt(data));
            }

            return null;
        }
    }
}
