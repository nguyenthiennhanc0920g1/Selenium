package pageobject;

import common.util.Scroll;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By emailTxt = By.id("username");
    private final By passwordTxt = By.id("password");
    private final By loginButton = By.xpath("//input[@value='Login']");
    private final By registrationLink = By.xpath("//a[text()='Registration Page']");
    private final By forgotPasswordLink = By.xpath("//a[text()='Forgot Password page']");
    private final By emailResetPasswordTxt = By.id("email");
    private final By sendInstructionButton = By.xpath("//input[@value='Send Instructions']");
    private final By errorLoginFormMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By loginForm = By.xpath("//form[@class='LoginForm']");

    public By getEmailTxt() {
        return emailTxt;
    }

    public By getPasswordTxt() {
        return passwordTxt;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getRegistrationLink() {
        return registrationLink;
    }

    public By getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public By getEmailResetPasswordTxt() {
        return emailResetPasswordTxt;
    }

    public By getSendInstructionButton() {
        return sendInstructionButton;
    }

    public By getErrorLoginFormMessage() {
        return errorLoginFormMessage;
    }

    public By getLoginForm() {
        return loginForm;
    }

    public void login(String username, String password) {
        BasePage.webDriver.findElement(emailTxt).sendKeys(username);
        BasePage.webDriver.findElement(passwordTxt).sendKeys(password);
        Scroll.scrollToBottom();
        BasePage.webDriver.findElement(loginButton).click();
    }
}
