package testcase;

import common.common.Check;
import common.util.Number;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.LoginPage;
import pageobject.RegisterPage;

public class RegisterTest extends BaseTest {
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
    private static String rdEmail;
    private static final String password = "valid password";

    @Test
    public void TC07() {
        System.out.println("TC07-User can create new account");

        BasePage.goToTab(BasePage.getRegisterTab());

        rdEmail = Number.generateRandomInt(100000, 999999) + "@gmail.com";
        String rdPassport = Number.generateRandomInt(10000000, 99999999) + "";
        registerPage.register(rdEmail, password, password, rdPassport);

        String actualMessage = BasePage.webDriver.findElement(registerPage.getRegisterMessage()).getText();
        String expectedMessage = "Thank you for registering your account";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
    }

    @Test
    public void TC08() {
        System.out.println("TC08-User can't login with an account hasn't been activated");

        BasePage.goToTab(BasePage.getLoginTab());
        loginPage.login(rdEmail, password);
        Assert.assertFalse(Check.isCheckLogin(rdEmail), "Login successfully");
        try {
            String actualMessage = BasePage.webDriver.findElement(loginPage.getErrorLoginFormMessage()).getText();
            String expectedMessage = "Invalid username or password. Please try again.";
            String errorMessage = "The message content is incorrect";
            Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
