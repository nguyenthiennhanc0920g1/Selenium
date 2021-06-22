package testcase;

import common.common.Check;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.ChangePasswordPage;
import pageobject.LoginPage;
import pageobject.MyTicketPage;

public class TC06 extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private MyTicketPage myTicketPage = new MyTicketPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC06() {
        System.out.println("TC06-Additional pages display once user logged in");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Click on "Login" tab
        BasePage.goToTab(BasePage.getLoginTab());
        //STEP 3: Login with valid account
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Check.checkLoginException(Constant.USERNAME);
        //Expected Behavior:
        //"My ticket", "Change password" and "Logout" tabs are displayed
        //Click "My ticket" tab, user will be directed to My ticket page
        //Click "Change password" tab, user will be directed to Change password page
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
