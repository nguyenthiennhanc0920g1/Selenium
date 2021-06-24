package testcase;

import common.common.Check;
import common.common.Log;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.LoginPage;

public class TC08 extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC08() {
        BaseTest.extentTest = BaseTest.extentReports.createTest("TC08-User can't login with an account hasn't been activated");
        System.out.println("TC08-User can't login with an account hasn't been activated");

        //STEP 1: Navigate to QA Railway Website
        Log.logInfo("STEP 1: Navigate to QA Railway Website.");
        BasePage.webDriver.get(Constant.HOME_URL);

        //STEP 2: Click on "Login" tab
        Log.logInfo("STEP 2: Click on \"Login\" tab.");
        BasePage.goToTab(BasePage.getLoginTab());

        //STEP 3 & STEP 4: Enter username and password of account hasn't been activated & Click on "Login" button
        Log.logInfo("STEP 3: Enter username and password of account hasn't been activated.");
        Log.logInfo("STEP 4: Click on \"Login\" button.");
        loginPage.login(Constant.UNACTIVEUSERNAME, Constant.UNACTIVEPASSWORD);

        //Expected Behavior: User can't login and message "Invalid username or password. Please try again." appears.
        Assert.assertFalse(Check.isCheckLogin(Constant.UNACTIVEUSERNAME), "Login successfully");
        try {
            String actualMessage = BasePage.webDriver.findElement(loginPage.getErrorLoginFormMessage()).getText();
            String expectedMessage = "Invalid username or password. Please try again.";
            String errorMessage = "The message content is incorrect";
            Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}