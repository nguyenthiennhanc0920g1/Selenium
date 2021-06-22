package testcase;

import common.common.Check;
import constant.Constant;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.ChangePasswordPage;
import pageobject.LoginPage;

public class TC09 extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC09() {
        System.out.println("TC09-User can change password");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Login with valid account
        BasePage.goToTab(BasePage.getLoginTab());
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Check.checkLoginException(Constant.USERNAME);
        //STEP 3: Click on "Change Password" tab
        BasePage.goToTab(BasePage.getChangePasswordTab());
        //STEP 4 & STEP 5: Enter valid value into all fields & Click on "Change Password" button
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        //Expected Behavior: Message "Your password has been updated" appears.
        Check.checkChangePassword();
    }
}
