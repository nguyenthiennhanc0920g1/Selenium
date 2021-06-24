package testcase;

import common.common.Log;
import common.util.Number;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.RegisterPage;

public class TC10 extends BaseTest {
    private RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC10() {
        BaseTest.extentTest = BaseTest.extentReports.createTest("TC10-User can't create account with \"Confirm password\" is not the same with \"Password\"");
        System.out.println("TC10-User can't create account with \"Confirm password\" is not the same with \"Password\"");

        //STEP 1: Navigate to QA Railway Website
        Log.logInfo("STEP 1: Navigate to QA Railway Website.");
        BasePage.webDriver.get(Constant.HOME_URL);

        //STEP 2: Click on "Register" tab
        Log.logInfo("STEP 2: Click on \"Register\" tab.");
        BasePage.goToTab(BasePage.getRegisterTab());

        //STEP 3 & STEP 4: Enter valid information into all fields except "Confirm password" is not the same with "Password" & Click on "Register" button
        Log.logInfo("STEP 3: Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\".");
        Log.logInfo("STEP 4: Click on \"Register\" button.");
        String rdEmail = Number.generateRandomInt(100000, 999999) + "@gmail.com";
        String rdPassport = Number.generateRandomInt(10000000, 99999999) + "";
        String password = "valid password";
        String confirmPassword = password + Number.generateRandomInt(1, 9);
        registerPage.register(rdEmail, password, confirmPassword, rdPassport);

        //Expected Behavior: Message "There're errors in the form. Please correct the errors and try again." appears.
        String actualMessage = BasePage.webDriver.findElement(registerPage.getRegisterErrorMessage()).getText();
        String expectedMessage = "There're errors in the form. Please correct the errors and try again.";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
    }
}
