package pageobject;

import common.util.Scroll;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private final By loginLink = By.xpath("//a[text()='login']");
    private final By confirmationLink = By.xpath("//a[text()='here']");
    private final By emailTxt = By.id("email");
    private final By passwordTxt = By.id("password");
    private final By confirmPasswordTxt = By.id("confirmPassword");
    private final By passportTxt = By.id("pid");
    private final By registerButton = By.xpath("//input[@value='Register']");
    private final By registerMessage = By.xpath("//*[@id=\"content\"]/p");
    private final By registerErrorMessage = By.xpath("//p[@class='message error']");
    private final By passwordFieldErrorMessage = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By passportFieldErrorMessage = By.xpath("//label[@for='pid' and @class='validation-error']");


    public By getLoginLink() {
        return loginLink;
    }

    public By getRegisterMessage() {
        return registerMessage;
    }

    public By getConfirmationLink() {
        return confirmationLink;
    }

    public By getEmailTxt() {
        return emailTxt;
    }

    public By getRegisterErrorMessage() {
        return registerErrorMessage;
    }

    public By getPasswordFieldErrorMessage() {
        return passwordFieldErrorMessage;
    }

    public By getPassportFieldErrorMessage() {
        return passportFieldErrorMessage;
    }

    public By getPasswordTxt() {
        return passwordTxt;
    }

    public By getConfirmPasswordTxt() {
        return confirmPasswordTxt;
    }

    public By getPassportTxt() {
        return passportTxt;
    }

    public By getRegisterButton() {
        return registerButton;
    }

    public void register(String email, String password, String confirmPassword, String passportNumber) {
        Scroll.scrollToBottom();
        BasePage.webDriver.findElement(emailTxt).sendKeys(email);
        BasePage.webDriver.findElement(passwordTxt).sendKeys(password);
        BasePage.webDriver.findElement(confirmPasswordTxt).sendKeys(confirmPassword);
        BasePage.webDriver.findElement(passportTxt).sendKeys(passportNumber);
        BasePage.webDriver.findElement(registerButton).click();
    }
}