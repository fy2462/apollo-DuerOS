package com.baidu.che.codriver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICoDriverListener extends IInterface {
    String onCommand(String var1, String var2, String var3, String var4) throws RemoteException;

    public abstract static class CoDriverListenerWrap extends Binder implements ICoDriverListener {
        public CoDriverListenerWrap() {
            this.attachInterface(this, "com.baidu.che.codriver.ICoDriverListener");
        }

        public static ICoDriverListener createDriverListener(IBinder obj) {
            if (obj == null) {
                return null;
            } else {
                IInterface iin = obj.queryLocalInterface("com.baidu.che.codriver.ICoDriverListener");
                return (ICoDriverListener)(iin != null && iin instanceof ICoDriverListener ? (ICoDriverListener)iin : new ICoDriverListener.CoDriverListenerWrap.CoDriverListener(obj));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1:
                    data.enforceInterface("com.baidu.che.codriver.ICoDriverListener");
                    String _arg0 = data.readString();
                    String _arg1 = data.readString();
                    String _arg2 = data.readString();
                    String _arg3 = data.readString();
                    String _result = this.onCommand(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 1598968902:
                    reply.writeString("com.baidu.che.codriver.ICoDriverListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class CoDriverListener implements ICoDriverListener {
            private IBinder remote;

            CoDriverListener(IBinder remote) {
                this.remote = remote;
            }

            public IBinder asBinder() {
                return this.remote;
            }

            public String onCommand(String pkg, String cmd, String param, String data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String _result;
                try {
                    _data.writeInterfaceToken("com.baidu.che.codriver.ICoDriverListener");
                    _data.writeString(pkg);
                    _data.writeString(cmd);
                    _data.writeString(param);
                    _data.writeString(data);
                    this.remote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }
        }
    }
}
