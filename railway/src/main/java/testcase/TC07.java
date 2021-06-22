package testcase;

import common.common.Check;
import common.util.Number;
import constant.Constant;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.RegisterPage;

public class TC07 extends BaseTest {
    private RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07() {
        System.out.println("TC07-User can create new account");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Click on "Register" tab
        BasePage.goToTab(BasePage.getRegisterTab());
        //STEP 3 & STEP 4: Enter valid information into all fields & Click on "Register" button
        String rdEmail = Number.generateRandomInt(100000, 999999) + "@gmail.com";
        String rdPassport = Number.generateRandomInt(10000000, 99999999) + "";
        String password = "valid password";
        registerPage.register(rdEmail, password, password, rdPassport);
        //Expected Behavior: New account is created and message "Thank you for registering your account" appears.
        Check.checkRegister();
    }
}
