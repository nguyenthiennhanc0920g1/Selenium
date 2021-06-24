package common.common;

import com.aventstack.extentreports.Status;
import testcase.BaseTest;

public class Log {
    public static void logInfo(String stepName) {
        BaseTest.extentTest.log(Status.INFO, stepName);
    }
}
