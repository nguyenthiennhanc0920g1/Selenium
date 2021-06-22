package testcase;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.LoginPage;

public class TC05 extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC05() {
        System.out.println("TC05-System shows message when user enters wrong password several times");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Click on "Login" tab
        BasePage.goToTab(BasePage.getLoginTab());
        //STEP 3 & STEP 4 & STEP 5:
        //Enter valid information into "Username" textbox except "Password" textbox.
        //Click on "Login" button
        //Repeat step 3 three more times.
        for (int i = 0; i < 6; i++) {
            loginPage.login(Constant.USERNAME, "invalid password");
            BasePage.webDriver.findElement(loginPage.getEmailTxt()).clear();
        }
        //Expected Behavior: User can't login and message "You have used 4 out of 5 login attempts. After all 5 have been used, you
        String actualMessage = BasePage.webDriver.findElement(loginPage.getErrorLoginFormMessage()).getText();
        String expectedMessage = "You have used 4 out of 5 login attempts. After all 5 have been used," +
                " you will be unable to login for 15 minutes.";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
    }
}
