package testcase;

import common.common.Check;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.*;

public class LoginTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final LogoutPage logoutPage = new LogoutPage();
    private final MyTicketPage myTicketPage = new MyTicketPage();
    private final ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC01() {
        System.out.println("TC01-User can log into Railway with valid username and password");

        BasePage.goToTab(BasePage.getLoginTab());
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Check.checkLoginException(Constant.USERNAME);
        logoutPage.logout();
        Assert.assertTrue(BasePage.webDriver.findElement(BasePage.getLoginTab()).isDisplayed(), "Logout fail");
    }

    @Test
    public void TC02() {
        System.out.println("TC02-User can't login with blank \"Username\" textbox");

        BasePage.goToTab(BasePage.getLoginTab());
        loginPage.login("", Constant.PASSWORD);
        String actual = BasePage.webDriver.findElement(loginPage.getErrorLoginFormMessage()).getText();
        String expected = "There was a problem with your login and/or errors exist in your form.";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actual, expected, errorMessage);
    }

    @Test
    public void TC03() {
        System.out.println("TC03-User cannot log into Railway with invalid password ");

        BasePage.goToTab(BasePage.getLoginTab());
        loginPage.login(Constant.USERNAME, "invalid password");
        String actualMessage = BasePage.webDriver.findElement(loginPage.getErrorLoginFormMessage()).getText();
        String expectedMessage = "There was a problem with your login and/or errors exist in your form.";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
    }

    @Test
    public void TC04() {
        System.out.println("TC04-Login page displays when un-logged User clicks on \"Book ticket\" tab");

        BasePage.goToTab(BasePage.getBookTicketTab());
        String errorMessage = "Do not find login form";
        Assert.assertTrue(BasePage.webDriver.findElement(loginPage.getLoginForm()).isDisplayed(), errorMessage);
    }

    @Test
    public void TC05() {
        System.out.println("TC05-System shows message when user enters wrong password several times");

        for (int i = 0; i < 6; i++) {
            loginPage.login(Constant.USERNAME, "invalid password");
            BasePage.webDriver.findElement(loginPage.getEmailTxt()).clear();
        }

        String actualMessage = BasePage.webDriver.findElement(loginPage.getErrorLoginFormMessage()).getText();
        String expectedMessage = "You have used 4 out of 5 login attempts. After all 5 have been used," +
                " you will be unable to login for 15 minutes.";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
    }

    @Test
    public void TC06() {
        System.out.println("TC06-Additional pages display once user logged in");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Check.checkLoginException(Constant.USERNAME);

        Assert.assertTrue(BasePage.webDriver.findElement(BasePage.getMyTicketTab()).isDisplayed(),
                "Do not find My Ticket Tab");
        Assert.assertTrue(BasePage.webDriver.findElement(BasePage.getChangePasswordTab()).isDisplayed(),
                "Do not find Change Password Tab");
        Assert.assertTrue(BasePage.webDriver.findElement(BasePage.getLogoutTab()).isDisplayed(),
                "Do not find Log out Tab");

        BasePage.goToTab(BasePage.getMyTicketTab());
        Assert.assertTrue(BasePage.webDriver.findElement(myTicketPage.getTitle()).isDisplayed(),
                "Do not find My Ticket Page");

        BasePage.goToTab(BasePage.getChangePasswordTab());
        Assert.assertTrue(BasePage.webDriver.findElement(changePasswordPage.getTitle()).isDisplayed(),
                "Do not find Change Password Page");
    }
}
