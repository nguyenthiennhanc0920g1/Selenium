package testcase;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.LoginPage;

public class TC02 extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC02() {
        System.out.println("TC02-User can't login with blank \"Username\" textbox");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Click on "Login" tab
        BasePage.goToTab(BasePage.getLoginTab());
        //STEP 3 & STEP 4: User doesn't type any words into "Username" textbox but enter valid information into "Password" textbox & Click on "Login" button
        loginPage.login("", Constant.PASSWORD);
        //Expected Behavior: User can't login and message "There was a problem with your login and/or errors exist in your form. " appears.
        String actual = BasePage.webDriver.findElement(loginPage.getErrorLoginFormMessage()).getText();
        String expected = "There was a problem with your login and/or errors exist in your form.";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actual, expected, errorMessage);
    }
}
