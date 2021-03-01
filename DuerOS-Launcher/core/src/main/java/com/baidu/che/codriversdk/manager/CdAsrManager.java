package com.baidu.che.codriversdk.manager;

import android.text.TextUtils;
import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.baidu.che.codriversdk.handler.AsrControlHandler;

public class CdAsrManager implements INoProguard {
    private static final String TAG = "CdAsrManager";
    public static final String ASR_TOOL = "asr.tool";
    private Map<String, CdAsrManager.SceneCommand> mCmdMap = new HashMap();
    private AsrControlHandler mReceiveHandler = new AsrControlHandler();

    public CdAsrManager() {
    }

    private static class CdAsrManagerHoler  {
        private static CdAsrManager instance = new CdAsrManager();
    }

    public static CdAsrManager getInstance() {
        return CdAsrManagerHoler.instance;
    }

    public void setAsrTool(CdAsrManager.AsrTool tool) {
        this.mReceiveHandler.setAsrTool(tool);
        RequestManager.getInstance().sendRequest("asr.tool", "set", (String)null);
        RequestManager.getInstance().addCommandHandler("asr.tool", this.mReceiveHandler);
    }

    public void sendRequest(String param, String data) {
        RequestManager.getInstance().sendRequest("asr.tool", param, data);
    }

    public void disableAsr() {
        this.sendRequest("disable_asr", (String)null);
    }

    public void enableAsr() {
        this.sendRequest("enable_asr", (String)null);
    }

    public void openDialog() {
        this.sendRequest("open_dialog", (String)null);
    }

    public void closeDialog() {
        this.sendRequest("close_dialog", (String)null);
    }

    public void openFullBargin() {
        this.sendRequest("open_bargin", (String)null);
    }

    public void closeFullBargin() {
        this.sendRequest("close_bargin", (String)null);
    }

    public void openSceneCmd() {
        this.sendRequest("open_scenecmd", (String)null);
    }

    public void closeSceneCmd() {
        this.sendRequest("close_scenecmd", (String)null);
    }

    public void clickVrButton() {
        this.sendRequest("click_vr_button", (String)null);
    }

    public boolean registerCmd(CdAsrManager.SceneCommand sceneCommand) {
        return this.sendSceneCommand(sceneCommand);
    }

    public boolean unregisterCmd(String id) {
        if (this.mCmdMap.containsKey(id)) {
            this.mCmdMap.remove(id);
            this.sendRequest("unregister_cmd", id);
            return true;
        } else {
            return false;
        }
    }

    public void addWakeUpWord(String word) {
        this.sendRequest("add_wakeup", word);
    }

    private boolean sendSceneCommand(CdAsrManager.SceneCommand sceneCommand) {
        if (!TextUtils.isEmpty(sceneCommand.getId()) && sceneCommand.contentArray.length() != 0) {
            JSONObject obj = new JSONObject();

            try {
                obj.put("cmd_id", sceneCommand.getId());
                obj.put("cmd_content", sceneCommand.contentArray);
            } catch (JSONException var4) {
                var4.printStackTrace();
                return false;
            }

            LogUtil.d("CdAsrManager", "sendSceneCommand(): sceneCommand=" + obj.toString());
            this.sendRequest("register_cmd", obj.toString());
            this.mCmdMap.put(sceneCommand.getId(), sceneCommand);
            RequestManager.getInstance().addCommandHandler("asr.tool", this.mReceiveHandler);
            return true;
        } else {
            LogUtil.d("CdAsrManager", "sendSceneCommand(): sceneCommand.getId())=" + sceneCommand.getId());
            return false;
        }
    }

    public void onCommand(String hashKey, String cmdKey, String cmdText) {
        if (!TextUtils.isEmpty(hashKey) && !TextUtils.isEmpty(cmdKey) && !TextUtils.isEmpty(cmdText)) {
            CdAsrManager.SceneCommand sceneCommand = (CdAsrManager.SceneCommand)this.mCmdMap.get(hashKey);
            if (sceneCommand == null) {
                LogUtil.e("CdAsrManager", "--onCommand sceneCommand is null!!!----");
            } else {
                sceneCommand.onCommand(cmdKey, cmdText);
            }
        } else {
            LogUtil.e("CdAsrManager", "--onCommand param is null!!!----");
        }
    }

    public interface AsrTool extends INoProguard {
        void onVrDialogShow();

        void onVrDialogDismiss();
    }

    public abstract static class SceneCommand implements INoProguard {
        private JSONArray contentArray = new JSONArray();

        public SceneCommand() {
        }

        public CdAsrManager.SceneCommand addCommand(String type, String... cmds) {
            JSONArray textArray = new JSONArray();
            String[] var4 = cmds;
            int var5 = cmds.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String cmd = var4[var6];
                textArray.put(cmd);
            }

            try {
                JSONObject contentObject = new JSONObject();
                contentObject.put("cmd_key", type.toString());
                contentObject.put("cmd_text", textArray);
                this.contentArray.put(contentObject);
            } catch (JSONException var8) {
                var8.printStackTrace();
            }

            LogUtil.e("CdAsrManager", "addCommand(): contentArray=" + this.contentArray.toString());
            return this;
        }

        public abstract void onCommand(String var1, String var2);

        public abstract String getId();
    }

}
