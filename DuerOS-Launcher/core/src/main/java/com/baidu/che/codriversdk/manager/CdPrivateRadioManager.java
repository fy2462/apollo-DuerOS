//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.RadioHandler;
import java.util.List;

public class CdPrivateRadioManager implements INoProguard {

    public static final String TAG = "CdPrivateRadioManager";
    public static final String PRIVATE_RADIO_TOOL = "private_radio.tool";

    public CdPrivateRadioManager() {
    }

    private static class CdPrivateRadioManagerHolder {
        private static CdPrivateRadioManager instance = new CdPrivateRadioManager();
    }

    public static CdPrivateRadioManager getInstance() {
        return CdPrivateRadioManagerHolder.instance;
    }

    public void setPrivateRadioTool(CdPrivateRadioManager.PrivateRadioTool tool) {
        RequestManager.getInstance().sendRequest(PRIVATE_RADIO_TOOL, "set", (String)null);
        RequestManager.getInstance().addCommandHandler(PRIVATE_RADIO_TOOL, new RadioHandler(tool));
    }

    public static class PrivateRadioModel implements INoProguard {
        public String type;
        public String person;
        public String programName;
        public List<String> keywords;
        public String rawJsonResult;

        public PrivateRadioModel() {
        }
    }

    public interface PrivateRadioTool extends INoProguard {
        void openPrivateRadio(CdPrivateRadioManager.PrivateRadioModel var1);
    }

}
