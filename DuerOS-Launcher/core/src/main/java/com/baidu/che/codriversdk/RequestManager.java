//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.che.codriversdk.PlatformService.ServiceBinder;
import com.baidu.che.codriversdk.INoProguard;

import java.io.Serializable;

public class RequestManager implements INoProguard {
    private static final String TAG = "RequestManager";
    private static RequestManager mInstance;
    private PlatformService mLocalService;
    private InitListener mInitListener;
    private boolean mInitCompleted;
    private Context mContext;
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtil.d(TAG, "onServiceConnected ComponentName=" + name.getPackageName());
            ServiceBinder binder = (ServiceBinder)service;
            RequestManager.this.mLocalService = binder.getServiceBinder();
            if (RequestManager.this.mLocalService.isConnectedToRemote() && !RequestManager.this.mInitCompleted) {
                if (RequestManager.this.mInitListener != null) {
                    LogUtil.i(TAG, "onServiceConnected mInitListener != null call onConnectedToRemote");
                    RequestManager.this.mInitListener.onConnectedToRemote();
                } else {
                    LogUtil.e(TAG, "onServiceConnected mInitListener == null");
                }

                RequestManager.this.mInitCompleted = true;
            } else {
                LogUtil.e(TAG, "onServiceConnected mLocalService.isConnectedToRemote() = " + RequestManager.this.mLocalService.isConnectedToRemote() + ", mInitCompleted = " + RequestManager.this.mInitCompleted);
            }

        }

        public void onServiceDisconnected(ComponentName name) {
            LogUtil.d(TAG, "onServiceDisconnected ComponentName=" + name.getPackageName());
            RequestManager.this.mLocalService = null;
            Intent intent = new Intent(RequestManager.this.mContext, PlatformService.class);
            RequestManager.this.mContext.startService(intent);
            RequestManager.this.mContext.bindService(intent, RequestManager.this.mConnection, Context.BIND_AUTO_CREATE);
        }
    };

    private RequestManager() {
    }

    public static RequestManager getInstance() {
        if (mInstance == null) {
            Class var0 = RequestManager.class;
            synchronized(RequestManager.class) {
                if (mInstance == null) {
                    mInstance = new RequestManager();
                }
            }
        }

        return mInstance;
    }

    public void init(Context context, InitListener listener) {
        this.mInitListener = listener;
        this.mContext = context;
        Intent intent = new Intent(context, PlatformService.class);
        context.startService(intent);
        context.bindService(intent, this.mConnection, Context.BIND_AUTO_CREATE);
    }

    public void sendRequest(String cmd, String param, String data) {
        if (this.mLocalService != null) {
            this.mLocalService.sendRequest(cmd, param, data);
        }

    }

    public boolean isSystemSleep() {
        return this.mLocalService != null ? this.mLocalService.isSystemSleep() : false;
    }

    public void setIsSystemSleep(boolean isSystemSleep) {
        if (this.mLocalService != null) {
            this.mLocalService.setIsSystemSleep(isSystemSleep);
        }

    }

    public void addCommandHandler(String cmd, RequestManager.ICmdHandler commandHandler) {
        if (this.mLocalService != null) {
            this.mLocalService.addCommandHandler(cmd, commandHandler);
        }

    }

    void doAfterConnectedToRemote() {
        if (!this.mInitCompleted && this.mLocalService != null) {
            if (this.mInitListener != null) {
                this.mInitListener.onConnectedToRemote();
            }

            this.mInitCompleted = true;
        }

    }

    void doAfterRemoteDisconnected() {
        this.mInitCompleted = false;
        if (this.mInitListener != null) {
            this.mInitListener.onDisconnectedToRemote();
        }

    }

    public int feedAudioBuffer(byte[] micData, byte[] spkData) {
        return this.mLocalService == null ? -1 : this.mLocalService.feedAudioBuffer(micData, spkData);
    }

    public int feedRawAudioBuffer(byte[] rawData) {
        return this.mLocalService == null ? -1 : this.mLocalService.feedRawAudioBuffer(rawData);
    }

    public interface ICmdHandler {
        String handle(String cmd, String param, String data);
    }
}
