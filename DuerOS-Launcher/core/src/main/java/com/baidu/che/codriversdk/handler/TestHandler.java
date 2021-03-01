package com.baidu.che.codriversdk.handler;

import com.baidu.che.codriversdk.RequestManager.ICmdHandler;
import com.baidu.che.codriversdk.manager.CdTestManager.TestTool;

public class TestHandler implements ICmdHandler {
    private TestTool tool;

    public TestHandler(TestTool testTool) {
        this.tool = testTool;
    }

    public String handle(String cmd, String param, String data) {
        if (this.tool == null) {
            return null;
        } else {
            this.tool.test(param);
            return null;
        }
    }
}
