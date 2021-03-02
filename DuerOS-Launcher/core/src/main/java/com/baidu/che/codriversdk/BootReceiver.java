//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

    public static final String TAG = "BootReceiver";

    public BootReceiver() {
    }

    public void onReceive(Context context, Intent intent) {
        LogUtil.d(TAG, "onReceive");
        if (intent != null) {
            LogUtil.d(TAG, "BootReceiver：" + intent.getAction());
            if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                LogUtil.d(TAG, "Action: android.intent.action.BOOT_COMPLETED");
            } else if (intent.getAction().equals("com.baidu.che.codrivercustom.START")) {
                LogUtil.d(TAG, "Action: com.baidu.che.codrivercustom.START");
            }

        }
    }
}
