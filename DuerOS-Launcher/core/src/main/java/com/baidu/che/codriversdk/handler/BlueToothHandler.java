package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdBlueToothManager;
import com.baidu.che.codriversdk.manager.CdBlueToothManager.BlueToothTool;

public class BlueToothHandler implements ICmdHandler {

    public static final String TAG = "BlueToothHandler";

    private BlueToothTool mBlueToothTool;

    public BlueToothHandler(BlueToothTool tool) {
        this.mBlueToothTool = tool;
    }

    public String handle(String cmd, String param, String data) {
        LogUtil.e(TAG, "onReceiveCommand-cmdType:" + cmd + ";param:" + param);
        if (this.mBlueToothTool == null) {
            return null;
        } else {
            if (CdBlueToothManager.BT_TOOL.equals(cmd)) {
                if ("bt_view".equals(param)) {
                    this.mBlueToothTool.openBlueToothView();
                } else if ("bt_contract_down_view".equals(param)) {
                    this.mBlueToothTool.openContractDownloadView();
                }
            }

            return null;
        }
    }
}
