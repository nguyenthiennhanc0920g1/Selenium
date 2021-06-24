package testcase;

import common.common.Check;
import constant.Constant;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.LoginPage;

public class TC01 extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC01() {
        BaseTest.extentTest = BaseTest.extentReports.createTest("TC01");
        System.out.println("TC01-User can log into Railway with valid username and password");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Click on "Login" tab
        BasePage.goToTab(BasePage.getLoginTab());
        //STEP 3 & STEP 4: Enter valid Email and Password & Click on "Login" button
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        //Expected Behavior: User is logged into Railway. Welcome user message is displayed.
        Check.checkLoginException(Constant.USERNAME);
    }
}
