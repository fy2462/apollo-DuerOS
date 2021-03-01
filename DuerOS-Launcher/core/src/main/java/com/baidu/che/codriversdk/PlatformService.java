//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.che.codriver.ICoDriverListener;
import com.baidu.che.codriver.ICoDriverService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriver.ICoDriverService.CoDriverServiceWrap;
import com.baidu.che.codriversdk.handler.SystemCommandHandler;

public class PlatformService extends Service implements INoProguard {
    public static final String TAG = "PlatformService";
    public static final int CONNECT = 101;
    private PlatformService.ServiceBinder mBinder = new PlatformService.ServiceBinder();
    private HandlerThread mRequestThread = new HandlerThread("RequestThread");
    private Handler mWorkHandler;
    private Handler mMainHandler;
    private ICoDriverService mCoDriverService;
    private Map<String, ICmdHandler> mCmdHandlerMap;
    private boolean mIsInitSuccess = false;
    private boolean mIsSystemSleep = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtil.d("PlatformService", "onServiceConnected ComponentName=" + name.getPackageName());
            PlatformService.this.mCoDriverService = CoDriverServiceWrap.createCoDriverService(service);

            try {
                PlatformService.this.mCoDriverService.registerListener(PlatformService.this.getPackageName(), PlatformService.this.mListener);
            } catch (RemoteException var4) {
                var4.printStackTrace();
            }

        }

        public void onServiceDisconnected(ComponentName name) {
            LogUtil.d("PlatformService", "onServiceDisconnected ComponentName=" + name.getPackageName());
            PlatformService.this.mCoDriverService = null;
            PlatformService.this.mIsInitSuccess = false;
            RequestManager.getInstance().doAfterRemoteDisconnected();
            PlatformService.this.reConnect();
        }
    };
    private ICoDriverListener mListener = new ICoDriverListener.CoDriverListenerWrap() {
        public String onCommand(String pkg, final String cmd, final String param, final String data) throws RemoteException {
            PlatformService.this.mMainHandler.post(new Runnable() {
                public void run() {
                    LogUtil.d("PlatformService", "onCommand cmd=" + cmd + " param=" + param);
                    PlatformService.this.dispatch(cmd, param, data);
                }
            });
            return null;
        }
    };

    public PlatformService() {
    }

    public IBinder onBind(Intent intent) {
        LogUtil.d("PlatformService", "onBind");
        return this.mBinder;
    }

    public void onCreate() {
        super.onCreate();
        LogUtil.d("PlatformService", "onCreate");
        this.startForeground(8888, new Notification());
        this.init();
        this.reConnect();
    }

    private void init() {
        this.mMainHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch(msg.what) {
                    case 101:
                        PlatformService.this.reConnect();
                    default:
                }
            }
        };
        this.mRequestThread.start();
        this.mWorkHandler = new Handler(this.mRequestThread.getLooper());
        this.mCmdHandlerMap = new ConcurrentHashMap();
        this.addCommandHandler("init.success", new SystemCommandHandler() {
            public String handle(String cmd, String param, String data) {
                PlatformService.this.mIsInitSuccess = true;
                RequestManager.getInstance().doAfterConnectedToRemote();
                return null;
            }
        });
    }

    private void connect() {
        LogUtil.d("PlatformService", "connect to codriver");
        Intent startIntent = new Intent("com.baidu.che.codriver.StartService");
        ComponentName componentName = new ComponentName("com.baidu.che.codriver", "com.baidu.che.codriver.sdk.CoDriverService");
        startIntent.setComponent(componentName);
        this.startService(startIntent);
        this.bindService(startIntent, this.mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private void reConnect() {
        if (this.mCoDriverService == null) {
            if (!this.mIsSystemSleep) {
                LogUtil.d("PlatformService", "reConnect");
                this.connect();
            }

            this.mMainHandler.sendEmptyMessageDelayed(101, 5000L);
        }

    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("PlatformService", "onDestroy");
        this.mMainHandler.removeMessages(101);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    boolean isConnectedToRemote() {
        return this.mIsInitSuccess;
    }

    boolean isSystemSleep() {
        return this.mIsSystemSleep;
    }

    void setIsSystemSleep(boolean isSystemSleep) {
        this.mIsSystemSleep = isSystemSleep;
    }

    void sendRequest(final String cmd, final String param, final String data) {
        LogUtil.d("PlatformService", "sendRequest " + cmd + " " + param);
        if (this.mCoDriverService != null) {
            this.mWorkHandler.post(new Runnable() {
                public void run() {
                    if (PlatformService.this.mCoDriverService != null) {
                        try {
                            PlatformService.this.mCoDriverService.sendCommand(PlatformService.this.getPackageName(), cmd, param, data);
                        } catch (RemoteException var2) {
                            var2.printStackTrace();
                        }
                    }

                }
            });
        } else {
            this.reConnect();
        }

    }

    void addCommandHandler(String cmd, RequestManager.ICmdHandler commandHandler) {
        this.mCmdHandlerMap.put(cmd, commandHandler);
    }

    private void dispatch(String cmd, String param, String data) {
        RequestManager.ICmdHandler commandHandler = this.mCmdHandlerMap.get(cmd);
        if (commandHandler != null) {
            commandHandler.handle(cmd, param, data);
        }

    }

    public int feedAudioBuffer(byte[] micData, byte[] spkData) {
        if (this.mCoDriverService != null) {
            try {
                this.mCoDriverService.feedAudioBuffer(micData, spkData);
            } catch (Exception var4) {
                var4.printStackTrace();
                return -1;
            }

            return micData.length;
        } else {
            return -1;
        }
    }

    public int feedRawAudioBuffer(byte[] rawData) {
        if (this.mCoDriverService != null) {
            try {
                this.mCoDriverService.feedRawAudioBuffer(rawData);
            } catch (Exception var3) {
                var3.printStackTrace();
                return -1;
            }

            return rawData.length;
        } else {
            return -1;
        }
    }

    class ServiceBinder extends Binder {
        ServiceBinder() {}

        PlatformService getServiceBinder() {
            return PlatformService.this;
        }
    }
}
