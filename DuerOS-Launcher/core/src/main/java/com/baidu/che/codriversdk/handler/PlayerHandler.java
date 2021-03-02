package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdPlayerManager;
import com.baidu.che.codriversdk.manager.CdPlayerManager.PlayerTool;

public class PlayerHandler implements ICmdHandler {
    private PlayerTool tool;

    public PlayerHandler(PlayerTool musicTool) {
        this.tool = musicTool;
    }

    public String handle(String cmd, String param, String data) {
        if (this.tool == null) {
            return null;
        }
        if (CdPlayerManager.PLAYER_TOOL.equals(cmd)) {
            if ("play".equals(param)) {
                this.tool.play();
            } else if ("pause".equals(param)) {
                this.tool.pause();
            } else if ("prev".equals(param)) {
                this.tool.prev();
            } else if ("next".equals(param)) {
                this.tool.next();
            } else if ("exit".equals(param)) {
                this.tool.exit();
            } else if ("switch.mode".equals(param)) {
                this.tool.switchMode(Integer.parseInt(data));
            } else if ("change".equals(param)) {
                this.tool.change();
            }
        }
        return null;
    }
}
