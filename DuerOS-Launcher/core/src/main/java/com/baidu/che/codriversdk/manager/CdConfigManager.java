package com.baidu.che.codriversdk.manager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.InitListener;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.ConfigHandler;
import java.util.Iterator;
import java.util.List;

public class CdConfigManager implements INoProguard {
    public static final String CONFIG_TOOL = "config.tool";
    public static final String PKG_NAME_CODRIVER = "com.baidu.che.codriver";
    public static final String PKG_NAME_LAUNCHER = "com.baidu.che.codriverlauncher";
    public static final String PKG_NAME_NAVI = "com.baidu.naviauto";
    public static final String PKG_NAME_RADIO = "com.baidu.car.radio";
    private Context mContext;

    public CdConfigManager() {
    }

    private static class CdConfigManagerHolder {
        private static CdConfigManager instance = new CdConfigManager();
    }

    public static CdConfigManager getInstance() {
        return CdConfigManagerHolder.instance;
    }

    public void initialize(Context context, InitListener listener) {
        this.mContext = context;
        RequestManager.getInstance().init(context, new CdConfigManager.InitListenerWrapper(listener));
    }

    private void setConfigTool() {
        RequestManager.getInstance().sendRequest("config.tool", "set", (String)null);
        RequestManager.getInstance().addCommandHandler("config.tool", new ConfigHandler());
    }

    public void setMusicType(CdConfigManager.MusicType musicType) {
        RequestManager.getInstance().sendRequest("config.tool", "set_music_type", musicType.name());
    }

    private void setLogLevel(int level) {
        RequestManager.getInstance().sendRequest("config.tool", "set_log_level", "" + level);
    }

    public void setDisplayView(CdConfigManager.DisplayView view) {
        if (view == CdConfigManager.DisplayView.ACTIVITY) {
            RequestManager.getInstance().sendRequest("config.tool", "set_display_view", "activity");
        } else {
            RequestManager.getInstance().sendRequest("config.tool", "set_display_view", "dialog");
        }

    }

    public void notifySystemSleep() {
        RequestManager.getInstance().setIsSystemSleep(true);
        RequestManager.getInstance().sendRequest("config.tool", "notify_system_sleep", (String)null);
    }

    public void notifySystemWakeUp() {
        RequestManager.getInstance().setIsSystemSleep(false);
        RequestManager.getInstance().sendRequest("config.tool", "notify_system_wakeup", (String)null);
    }

    public String getDuerOSVersion() {
        String codriverVersionName = this.getAppVersionName("com.baidu.che.codriver");
        int launcherVersionCode = this.getAppVersionCode("com.baidu.che.codriverlauncher");
        int naviVersionCode = this.getAppVersionCode("com.baidu.naviauto");
        int radioVersionCode = this.getAppVersionCode("com.baidu.car.radio");
        return codriverVersionName + "." + (launcherVersionCode + naviVersionCode + radioVersionCode);
    }

    private int getAppVersionCode(String pkgName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        if (packageInfos != null && packageInfos.size() > 0) {
            Iterator var4 = packageInfos.iterator();

            while(var4.hasNext()) {
                PackageInfo packageInfo = (PackageInfo)var4.next();
                if (TextUtils.equals(packageInfo.packageName, pkgName)) {
                    return packageInfo.versionCode;
                }
            }
        }

        return 0;
    }

    private String getAppVersionName(String pkgName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        if (packageInfos != null && packageInfos.size() > 0) {
            Iterator var4 = packageInfos.iterator();

            while(var4.hasNext()) {
                PackageInfo packageInfo = (PackageInfo)var4.next();
                if (TextUtils.equals(packageInfo.packageName, pkgName)) {
                    return packageInfo.versionName;
                }
            }
        }

        return "1.0.0";
    }

    public static enum DisplayView implements INoProguard {
        DIALOG,
        ACTIVITY;

        private DisplayView() {
        }
    }

    public static enum MusicType implements INoProguard {
        CUSTOM_MUSIC,
        KUWO_MUSIC,
        BAIDU_RADIO;

        private MusicType() {
        }
    }

    private class InitListenerWrapper implements InitListener {
        private InitListener mInitListener;

        public InitListenerWrapper(InitListener initListener) {
            this.mInitListener = initListener;
        }

        public void onConnectedToRemote() {
            if (this.mInitListener != null) {
                this.mInitListener.onConnectedToRemote();
            }

            CdConfigManager.this.setConfigTool();
        }

        public void onDisconnectedToRemote() {
            if (this.mInitListener != null) {
                this.mInitListener.onDisconnectedToRemote();
            }

        }
    }
}
