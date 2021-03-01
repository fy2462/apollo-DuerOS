//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.che.codriversdk.manager.CdAsrManager;

public class RecordReceiver extends BroadcastReceiver {
    private static final String simpleName = RecordReceiver.class.getSimpleName();

    public RecordReceiver() {
    }

    public void onReceive(Context context, Intent intent) {
        LogUtil.d(simpleName, "onReceive");
        if (intent != null) {
            LogUtil.d(simpleName, "BootReceiver：" + intent.getAction());
            if (intent.getAction().equals("com.baidu.carlifevehicle.broadcast.CONNECTED")) {
                CdAsrManager.getInstance().disableAsr();
            } else if (intent.getAction().equals("com.baidu.carlifevehicle.broadcast.DISCONNECTED")) {
                CdAsrManager.getInstance().enableAsr();
            }

        }
    }
}
