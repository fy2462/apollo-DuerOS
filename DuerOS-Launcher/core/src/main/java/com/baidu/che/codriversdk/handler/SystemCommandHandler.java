package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdSystemManager.DrivingRecorderTool;
import com.baidu.che.codriversdk.manager.CdSystemManager.SystemTool;
import com.baidu.che.codriversdk.manager.CdSystemManager.DrivingRecorderTool.CameraType;
import com.baidu.che.codriversdk.manager.CdSystemManager.DrivingRecorderTool.DrivingRecorderState;
import com.baidu.che.codriversdk.manager.CdSystemManager.DrivingRecorderTool.Switch;
import org.json.JSONException;
import org.json.JSONObject;

public class SystemCommandHandler implements ICmdHandler {
    private SystemTool mSystemTool;
    private DrivingRecorderTool mRecorderTool;

    public SystemCommandHandler() {
    }

    public void setSystemTool(SystemTool tool) {
        this.mSystemTool = tool;
    }

    public void setDrivingRecorderTool(DrivingRecorderTool recorderTool) {
        this.mRecorderTool = recorderTool;
    }

    public String handle(String cmd, String param, String data) {
        LogUtil.d("SystemCommandHandler", "onReceiveCommand-cmdType:" + cmd + ";param:" + param);
        if (!"system.tool".equals(cmd)) {
            return null;
        } else if (param == null) {
            return null;
        } else {
            if (this.mSystemTool != null) {
                if ("open".equals(param)) {
                    this.mSystemTool.openFeature(data);
                } else if ("close".equals(param)) {
                    this.mSystemTool.closeFeature(data);
                } else if ("up".equals(param)) {
                    this.mSystemTool.increaseFeature(data);
                } else if ("down".equals(param)) {
                    this.mSystemTool.reduceFeature(data);
                } else if ("max".equals(param)) {
                    this.mSystemTool.maxFeature(data);
                } else if ("min".equals(param)) {
                    this.mSystemTool.minFeature(data);
                } else if ("operate".equals(param)) {
                    try {
                        JSONObject jsonObject = new JSONObject(data.trim());
                        String feature = jsonObject.getString("feature");
                        String value = jsonObject.getString("value");
                        this.mSystemTool.operateFeature(feature, value);
                    } catch (JSONException var7) {
                        var7.printStackTrace();
                    }
                }
            }

            if (this.mRecorderTool != null) {
                if ("dr_type".equals(param)) {
                    if (data.equals(DrivingRecorderState.START.name())) {
                        this.mRecorderTool.drivingRecorder(DrivingRecorderState.START);
                    } else if (data.equals(DrivingRecorderState.STOP.name())) {
                        this.mRecorderTool.drivingRecorder(DrivingRecorderState.STOP);
                    } else if (data.equals(DrivingRecorderState.WATCH.name())) {
                        this.mRecorderTool.drivingRecorder(DrivingRecorderState.WATCH);
                    }
                } else if ("dr_mute".equals(param)) {
                    if (data.equals(Switch.OPEN.name())) {
                        this.mRecorderTool.recorderMuteOpen(Switch.OPEN);
                    } else if (data.equals(Switch.CLOSE.name())) {
                        this.mRecorderTool.recorderMuteOpen(Switch.CLOSE);
                    }
                } else if ("dr_carmer".equals(param)) {
                    if (data.equals(CameraType.FRONT_CAMERA.name())) {
                        this.mRecorderTool.openCamera(CameraType.FRONT_CAMERA);
                    } else if (data.equals(CameraType.INNER_CAMERA.name())) {
                        this.mRecorderTool.openCamera(CameraType.INNER_CAMERA);
                    } else if (data.equals(CameraType.BACK_CAMERA.name())) {
                        this.mRecorderTool.openCamera(CameraType.BACK_CAMERA);
                    }
                } else if ("dr_take_picture".equals(param)) {
                    this.mRecorderTool.takePicture();
                }
            }

            return null;
        }
    }
}
