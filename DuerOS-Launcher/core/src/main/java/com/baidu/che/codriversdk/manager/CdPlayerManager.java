//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.PlayerHandler;

public class CdPlayerManager implements INoProguard {

    public static final String TAG = "CdPlayerManager";
    public static final String PLAYER_TOOL = "player.tool";

    public CdPlayerManager() {
    }

    private static class CdPlayerManagerHolder {
        private static CdPlayerManager instance = new CdPlayerManager();
    }

    public static CdPlayerManager getInstance() {
        return CdPlayerManagerHolder.instance;
    }

    public void setPlayerTool(CdPlayerManager.PlayerTool tool) {
        RequestManager.getInstance().sendRequest(PLAYER_TOOL, "set", (String)null);
        RequestManager.getInstance().addCommandHandler(PLAYER_TOOL, new PlayerHandler(tool));
    }

    private void sendRequest(String param, String data) {
        RequestManager.getInstance().sendRequest(PLAYER_TOOL, param, data);
    }

    public void stopDefaultPlayer() {
        this.sendRequest("stop.native.music", (String)null);
    }

    public void nextDefaultPlayer() {
        this.sendRequest("next.native.music", (String)null);
    }

    public interface PlayerTool extends INoProguard {
        int MODE_SINGLE_LOOP = 0;
        int MODE_RANDOM = 1;
        int MODE_FULL_LOOP = 2;

        void play();

        void pause();

        void prev();

        void next();

        void exit();

        void switchMode(int var1);

        void change();
    }
}
