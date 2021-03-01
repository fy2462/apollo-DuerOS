package com.baidu.che.codriver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICoDriverService extends IInterface {
    String sendCommand(String var1, String var2, String var3, String var4) throws RemoteException;

    void registerListener(String var1, ICoDriverListener var2) throws RemoteException;

    void unRegisterListener(ICoDriverListener var1) throws RemoteException;

    void feedAudioBuffer(byte[] var1, byte[] var2) throws RemoteException;

    void feedRawAudioBuffer(byte[] var1) throws RemoteException;

    public abstract static class CoDriverServiceWrap extends Binder implements ICoDriverService {

        public static ICoDriverService createCoDriverService(IBinder obj) {
            if (obj == null) {
                return null;
            } else {
                IInterface iin = obj.queryLocalInterface("com.baidu.che.codriver.ICoDriverService");
                return (ICoDriverService)(iin != null && iin instanceof ICoDriverService ? (ICoDriverService)iin : new ICoDriverService.CoDriverServiceWrap.CoDriverService(obj));
            }
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            byte[] array;
            String str;
            switch(code) {
                case 1:
                    data.enforceInterface("com.baidu.che.codriver.ICoDriverService");
                    str = data.readString();
                    String _arg1 = data.readString();
                    String _arg2 = data.readString();
                    String _arg3 = data.readString();
                    String _result = this.sendCommand(str, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 2:
                    data.enforceInterface("com.baidu.che.codriver.ICoDriverService");
                    str = data.readString();
                    ICoDriverListener _arg11 = com.baidu.che.codriver.ICoDriverListener.CoDriverListenerWrap.createDriverListener(data.readStrongBinder());
                    this.registerListener(str, _arg11);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.baidu.che.codriver.ICoDriverService");
                    ICoDriverListener _arg01 = com.baidu.che.codriver.ICoDriverListener.CoDriverListenerWrap.createDriverListener(data.readStrongBinder());
                    this.unRegisterListener(_arg01);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.baidu.che.codriver.ICoDriverService");
                    array = data.createByteArray();
                    byte[] localArray = data.createByteArray();
                    this.feedAudioBuffer(array, localArray);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.baidu.che.codriver.ICoDriverService");
                    array = data.createByteArray();
                    this.feedRawAudioBuffer(array);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.baidu.che.codriver.ICoDriverService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class CoDriverService implements ICoDriverService {
            private IBinder remote;

            CoDriverService(IBinder remote) {
                this.remote = remote;
            }

            public IBinder asBinder() {
                return this.remote;
            }

            public String sendCommand(String pkg, String cmd, String param, String data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String _result;
                try {
                    _data.writeInterfaceToken("com.baidu.che.codriver.ICoDriverService");
                    _data.writeString(pkg);
                    _data.writeString(cmd);
                    _data.writeString(param);
                    _data.writeString(data);
                    this.remote.transact(IBinder.FIRST_CALL_TRANSACTION, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void registerListener(String pkg, ICoDriverListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("com.baidu.che.codriver.ICoDriverService");
                    _data.writeString(pkg);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.remote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void unRegisterListener(ICoDriverListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("com.baidu.che.codriver.ICoDriverService");
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.remote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void feedAudioBuffer(byte[] micData, byte[] spkData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("com.baidu.che.codriver.ICoDriverService");
                    _data.writeByteArray(micData);
                    _data.writeByteArray(spkData);
                    this.remote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void feedRawAudioBuffer(byte[] rawData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("com.baidu.che.codriver.ICoDriverService");
                    _data.writeByteArray(rawData);
                    this.remote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }
        }
    }
}
