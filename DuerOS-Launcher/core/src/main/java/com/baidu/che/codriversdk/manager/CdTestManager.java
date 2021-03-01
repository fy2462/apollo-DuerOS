//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.baidu.che.codriversdk.manager;

import com.baidu.che.codriversdk.INoProguard;
import com.baidu.che.codriversdk.RequestManager;
import com.baidu.che.codriversdk.handler.TestHandler;

public class CdTestManager implements INoProguard {
    public CdTestManager() {
    }

    private static class CdTestManagerHolder {
        private static CdTestManager instance = new CdTestManager();
    }

    public static CdTestManager getInstance() {
        return CdTestManagerHolder.instance;
    }

    public void setTestTool(CdTestManager.TestTool tool) {
        RequestManager.getInstance().sendRequest("test.tool", "set", (String)null);
        RequestManager.getInstance().addCommandHandler("test.tool", new TestHandler(tool));
    }

    public interface TestTool extends INoProguard {
        void test(String var1);
    }

}
