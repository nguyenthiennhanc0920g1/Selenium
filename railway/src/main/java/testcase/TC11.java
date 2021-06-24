package testcase;

import common.util.Number;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.RegisterPage;

public class TC11 extends BaseTest {
    private RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC11() {
        System.out.println("TC11-User can't create account while password and PID fields are empty");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Click on "Register" tab
        BasePage.goToTab(BasePage.getRegisterTab());
        //STEP 3 & STEP 4: Enter valid email address and leave other fields empty & Click on "Register" button
        String rdEmail = Number.generateRandomInt(100000, 999999) + "@gmail.com";
        registerPage.register(rdEmail, "", "", "");
        //Expected Behavior:
        //Message "There're errors in the form. Please correct the errors and try again." appears above the form.
        //Next to password fields, error message "Invalid password length." displays
        //Next to PID field, error message "Invalid ID length." displays
        String actualMessage = BasePage.webDriver.findElement(registerPage.getRegisterErrorMessage()).getText();
        String actualPasswordMessage = BasePage.webDriver.findElement(registerPage.getPasswordFieldErrorMessage()).getText();
        String actualPassportMessage = BasePage.webDriver.findElement(registerPage.getPassportFieldErrorMessage()).getText();
        String expectedMessage = "There're errors in the form. Please correct the errors and try again.";
        String expectedPasswordMessage = "Invalid password length";
        String expectedPassportMessage = "Invalid ID length";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
        Assert.assertEquals(actualPasswordMessage, expectedPasswordMessage, errorMessage);
        Assert.assertEquals(actualPassportMessage, expectedPassportMessage, errorMessage);
    }
}
