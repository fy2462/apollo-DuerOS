//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    public BootReceiver() {
    }

    public void onReceive(Context context, Intent intent) {
        LogUtil.d("BootReceiver", "onReceive");
        if (intent != null) {
            LogUtil.d("BootReceiver", "BootReceiver：" + intent.getAction());
            if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                LogUtil.d("BootReceiver", "Action: android.intent.action.BOOT_COMPLETED");
            } else if (intent.getAction().equals("com.baidu.che.codrivercustom.START")) {
                LogUtil.d("BootReceiver", "Action: com.baidu.che.codrivercustom.START");
            }

        }
    }
}
