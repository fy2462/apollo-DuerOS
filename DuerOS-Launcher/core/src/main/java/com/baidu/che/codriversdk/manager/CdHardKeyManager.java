package com.baidu.che.codriversdk.manager;

import android.view.KeyEvent;
import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.HardKeyHandler;

public class CdHardKeyManager implements INoProguard {
    public static final String HARDKEY_TOOL = "hardkey.tool";

    public CdHardKeyManager() {
    }

    private static class CdHardKeyManagerHolder {
        private static CdHardKeyManager instance = new CdHardKeyManager();
    }

    public static CdHardKeyManager getInstance() {
        return CdHardKeyManagerHolder.instance;
    }

    public void setHardKeyTool(CdHardKeyManager.HardKeyTool tool) {
        RequestManager.getInstance().sendRequest("hardkey.tool", "set", (String)null);
        RequestManager.getInstance().addCommandHandler("hardkey.tool", new HardKeyHandler(tool));
    }

    public void sendHardKeyRequest(String param, String data) {
        RequestManager.getInstance().sendRequest("hardkey.tool", param, data);
    }

    public interface HardKeyTool extends INoProguard {
        void onKeyDown(int var1, KeyEvent var2);

        void onKeyUp(int var1, KeyEvent var2);

        void onSingleClick(int var1);

        void onLongClick(int var1);
    }

}
