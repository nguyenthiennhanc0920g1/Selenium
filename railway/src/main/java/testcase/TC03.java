package testcase;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.LoginPage;

public class TC03 extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC03() {
        BaseTest.extentTest = BaseTest.extentReports.createTest("TC01");
        System.out.println("TC03-User cannot log into Railway with invalid password ");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Click on "Login" tab
        BasePage.goToTab(BasePage.getLoginTab());
        //STEP 3 & STEP 4: Enter valid Email and invalid Password & Click on "Login" button
        loginPage.login(Constant.USERNAME, "invalid password");
        //Expected Behavior: Error message "There was a problem with your login and/or errors exist in your form." is displayed
        String actualMessage = BasePage.webDriver.findElement(loginPage.getErrorLoginFormMessage()).getText();
        String expectedMessage = "There was a problem with your login and/or errors exist in your form.";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
    }
}
