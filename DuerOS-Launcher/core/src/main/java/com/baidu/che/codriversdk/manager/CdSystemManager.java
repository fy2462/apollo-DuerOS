//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.SystemCommandHandler;

public class CdSystemManager implements INoProguard {
    public static final String SYSTEM_TOOL = "system.tool";
    public static final String FEATURE_VOLUME = "volume";
    public static final String FEATURE_BLUETOOTH = "bluetooth";
    public static final String FEATURE_LIGHT = "light";
    public static final String FEATURE_WIFI = "wifi";
    public static final String FEATURE_NETWORK = "network";
    public static final String FEATURE_SETTING = "system_setting";
    public static final String FEATURE_PICTURE = "picture";
    public static final String FEATURE_WIND_FLOW = "wind_flow";
    public static final String FEATURE_WIND_DIRECTION = "wind_direction";
    public static final String FEATURE_TEMP = "temp";
    public static final String FEATURE_CLIMATE = "climate";
    public static final String FEATURE_AIR_CONDITIONER = "air_conditioner";
    public static final String FEATURE_INTERNAL_RECYCLE = "internal_recycle";
    public static final String FEATURE_AIR_CLEAN = "air_clean";
    public static final String FEATURE_DEFROST = "defrost";
    public static final String FEATURE_HEAT_TEMP = "heat_temp";
    public static final String FEATURE_MUTE = "mute";
    private SystemCommandHandler mSystemCommandHandler;

    private CdSystemManager() {
        this.mSystemCommandHandler = new SystemCommandHandler();
        RequestManager.getInstance().addCommandHandler(CdSystemManager.SYSTEM_TOOL, this.mSystemCommandHandler);
    }

    private static class CdSystemManagerHolder {
        private static CdSystemManager instance = new CdSystemManager();
    }

    public static CdSystemManager getInstance() {
        return CdSystemManagerHolder.instance;
    }

    public void setSystemTool(CdSystemManager.SystemTool tool) {
        RequestManager.getInstance().sendRequest(CdSystemManager.SYSTEM_TOOL, "set", (String)null);
        this.mSystemCommandHandler.setSystemTool(tool);
    }

    public void setRecorderTool(CdSystemManager.DrivingRecorderTool drivingRecorderTool) {
        RequestManager.getInstance().sendRequest(CdSystemManager.SYSTEM_TOOL, "set", (String)null);
        this.mSystemCommandHandler.setDrivingRecorderTool(drivingRecorderTool);
    }

    public interface DrivingRecorderTool extends INoProguard {
        void drivingRecorder(CdSystemManager.DrivingRecorderTool.DrivingRecorderState var1);

        void recorderMuteOpen(CdSystemManager.DrivingRecorderTool.Switch var1);

        void openCamera(CdSystemManager.DrivingRecorderTool.CameraType var1);

        void takePicture();

        public static enum CameraType implements INoProguard {
            FRONT_CAMERA,
            INNER_CAMERA,
            BACK_CAMERA;

            private CameraType() {
            }
        }

        public static enum Switch implements INoProguard {
            OPEN,
            CLOSE;

            private Switch() {
            }
        }

        public static enum DrivingRecorderState implements INoProguard {
            WATCH,
            START,
            STOP;

            private DrivingRecorderState() {
            }
        }
    }

    public interface SystemTool extends INoProguard {
        void closeFeature(String var1);

        void openFeature(String var1);

        void increaseFeature(String var1);

        void reduceFeature(String var1);

        void maxFeature(String var1);

        void minFeature(String var1);

        void operateFeature(String var1, String var2);
    }
}
