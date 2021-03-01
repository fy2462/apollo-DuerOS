//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class CdNaviManager implements INoProguard {
    public static final String MAP_TOOL = "map.tool";

    public CdNaviManager() {
    }

    public static CdNaviManager getInstance() {
        return CdNaviManager.a.a;
    }

    public boolean sendStartNaviCommand(CdNaviManager.PoiModel mPoi) {
        if (Math.abs(mPoi.longitude) > 1.0E-6D && Math.abs(mPoi.latitude) > 1.0E-6D) {
            this.sendRequest("fun_navi_start_task", mPoi.createParamJson());
            return true;
        } else {
            return false;
        }
    }

    public void setDefaultNaviApp(CdNaviManager.NaviApp naviApp) {
        if (naviApp != null) {
            this.sendRequest("fun_navi_set_default_app", naviApp.name());
        }

    }

    public void setDayOrNightMode(boolean dayMode) {
        String data = dayMode ? "0" : "1";
        this.sendRequest("set_day_night_mode", data);
    }

    private void sendRequest(String param, String data) {
        RequestManager.getInstance().sendRequest("map.tool", param, data);
    }

    public static class PoiModel implements INoProguard {
        public String poiName;
        public double latitude;
        public double longitude;
        public String poiAddress;

        public PoiModel() {
        }

        protected String createParamJson() {
            JSONObject params = new JSONObject();

            try {
                params.putOpt("lat", (new BigDecimal(this.latitude * 100000.0D)).toString());
                params.putOpt("lng", (new BigDecimal(this.longitude * 100000.0D)).toString());
                params.putOpt("poiName", this.poiName);
                params.putOpt("poiRegion", this.poiAddress);
            } catch (JSONException var3) {
                var3.printStackTrace();
            }

            LogUtil.d("CdNaviManager", "createParamJson result = " + params.toString());
            return params.toString();
        }
    }

    private static class a {
        private static CdNaviManager a = new CdNaviManager();
    }

    public static enum NaviApp implements INoProguard {
        Baidu,
        Amap;

        private NaviApp() {
        }
    }
}
