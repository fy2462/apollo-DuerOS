//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk.manager;

import android.text.TextUtils;
import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.PhoneCommandHandler;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CdPhoneManager implements INoProguard {
    public static final String PHONE_TOOL = "phone.tool";

    public CdPhoneManager() {
    }

    private static class CdPhoneManagerHolder {
        private static CdPhoneManager instance = new CdPhoneManager();
    }

    public static CdPhoneManager getInstance() {
        return CdPhoneManagerHolder.instance;
    }

    public void setPhoneTool(CdPhoneManager.PhoneTool tool) {
        RequestManager.getInstance().sendRequest("phone.tool", "set", (String)null);
        RequestManager.getInstance().addCommandHandler("phone.tool", new PhoneCommandHandler(tool));
    }

    public void onNotifyPhoneStatus(CdPhoneManager.PhoneDownloadStatus status) {
        this.sendRequest("notify_phone_status", status.ordinal() + "");
    }

    public void sendRequest(String param, String data) {
        RequestManager.getInstance().sendRequest("phone.tool", param, data);
    }

    public void sendPhoneBookData(CdPhoneManager.PhoneContactList data) {
        this.sendRequest("phone_book_data", data.getJsonString());
    }

    public static enum PhoneDownloadStatus implements INoProguard {
        CONTACTS_NO_DOWNLOADED,
        ACTION_PBAP_DOWNLOAD_SUPPORT,
        CONTACTS_DOWNLOAD_REQUEST,
        CONTACTS_DOWNLOAD_STARTED,
        CONTACTS_DOWNLOAD_PROGRESS,
        CONTACTS_DOWNLOAD_COMPLETE,
        CONTACTS_UPDATE_READY,
        CONTACTS_UPDATE_COMPLETE,
        CALLLOGS_DOWNLOAD_STARTED,
        CALLLOGS_DOWNLOAD_PROGRESS,
        CALLLOGS_DOWNLOAD_COMPLETE,
        OTHER;

        private PhoneDownloadStatus() {
        }
    }

    public static class PhoneContactList implements INoProguard {
        private List<String> phoneNumberList = new ArrayList();
        private List<String> phoneDisplayName = new ArrayList();

        public PhoneContactList() {
        }

        public String getPhoneNumber(int result) {
            return this.phoneNumberList.size() > result && result >= 0 ? (String)this.phoneNumberList.get(result) : null;
        }

        public boolean addContact(String name, String number) {
            if (TextUtils.isEmpty(number)) {
                LogUtil.d("CdPhoneManager", "number is empty");
                return false;
            } else {
                this.phoneDisplayName.add(name);
                this.phoneNumberList.add(number);
                return true;
            }
        }

        public String getPhoneDisplayName(int result) {
            return this.phoneDisplayName.size() > result && result >= 0 ? (String)this.phoneDisplayName.get(result) : null;
        }

        public String getJsonString() {
            JSONObject mObject = new JSONObject();
            JSONArray mDisplayArray = new JSONArray();
            JSONArray mPhoneNumberArray = new JSONArray();

            for(int i = 0; i < this.phoneNumberList.size(); ++i) {
                mDisplayArray.put(this.phoneDisplayName.get(i));
                mPhoneNumberArray.put(this.phoneNumberList.get(i));
            }

            try {
                mObject.put("display_name", mDisplayArray);
                mObject.put("phone_number", mPhoneNumberArray);
            } catch (JSONException var5) {
                var5.printStackTrace();
            }

            return mObject.toString();
        }
    }

    public interface PhoneTool extends INoProguard {
        void dialNum(String var1);
    }

}
