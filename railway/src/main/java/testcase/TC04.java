package testcase;

import common.common.Log;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.LoginPage;

public class TC04 extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC04() {
        BaseTest.extentTest = BaseTest.extentReports.createTest("TC04-Login page displays when un-logged User clicks on \"Book ticket\" tab");
        System.out.println("TC04-Login page displays when un-logged User clicks on \"Book ticket\" tab");

        //STEP 1: Navigate to QA Railway Website
        Log.logInfo("STEP 1: Navigate to QA Railway Website.");
        BasePage.webDriver.get(Constant.HOME_URL);

        //STEP 2: Click on "Book ticket" tab
        Log.logInfo("STEP 2: Click on \"Book ticket\" tab.");
        BasePage.goToTab(BasePage.getBookTicketTab());

        //Expected Behavior: Login page displays instead of Book ticket page
        String errorMessage = "Do not find login form";
        Assert.assertTrue(BasePage.webDriver.findElement(loginPage.getLoginForm()).isDisplayed(), errorMessage);
    }
}
