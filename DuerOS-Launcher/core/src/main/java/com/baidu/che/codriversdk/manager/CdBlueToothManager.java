package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.BlueToothHandler;

public class CdBlueToothManager implements INoProguard {
    public static final String BT_TOOL = "bt.tool";
    private static CdBlueToothManager instance = null;

    public static CdBlueToothManager getInstance() {
        return CdBlueToothManagerHoler.instance;
    }

    private static class CdBlueToothManagerHoler  {
        private static CdBlueToothManager instance = new CdBlueToothManager();
    }

    private CdBlueToothManager() { }

    public void setBlueToothTool(CdBlueToothManager.BlueToothTool tool) {
        RequestManager.getInstance().sendRequest(BT_TOOL, "set", (String)null);
        RequestManager.getInstance().addCommandHandler(BT_TOOL, new BlueToothHandler(tool));
    }

    public void onNotifyBTStatus(CdBlueToothManager.BtStatus status) {
        this.sendRequest("bt_status_notify", status.ordinal() + "");
    }

    public void onNotifyBTPhoneStatus(CdBlueToothManager.BTPhoneStatus status) {
        this.sendRequest("bt_phone_notify", status.ordinal() + "");
    }

    /** @deprecated */
    @Deprecated
    public void onNotifyBTMediaStatus(int status) {
        this.sendRequest("bt_media_notify", status + "");
    }

    /** @deprecated */
    @Deprecated
    public void onNotifyBTService(int status) {
        this.sendRequest("bt_service_notify", status + "");
    }

    public void sendRequest(String param, String data) {
        RequestManager.getInstance().sendRequest(BT_TOOL, param, data);
    }

    public static enum BTPhoneStatus implements INoProguard {
        BT_PHONE_NO_AUTHORIZED,
        BT_PHONE_AUTHORIZING,
        BT_PHONE_AUTHORIZED,
        BT_PHONE_REQUESTING,
        BT_PHONE_RESERVED_1,
        BT_PHONE_RESERVED_2,
        BT_PHONE_CANNOT_AUTHORIZED;

        private BTPhoneStatus() {
        }
    }

    public static enum BtStatus implements INoProguard {
        BT_DISCONNECTED,
        BT_CONNECTING,
        BT_CONNECTED,
        BT_DISCONNECTING,
        BT_CANCELLING,
        BT_CANCELLED,
        BT_PAIRED,
        BT_NOPAIR;

        private BtStatus() {
        }
    }

    public interface BlueToothTool extends INoProguard {
        void openBlueToothView();

        void openContractDownloadView();
    }

}
