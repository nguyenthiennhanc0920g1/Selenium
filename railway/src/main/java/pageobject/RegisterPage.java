package pageobject;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private final By loginLink = By.xpath("//a[text()='login']");
    private final By confirmationLink = By.xpath("//a[text()='here']");
    private final By emailTxt = By.id("email");
    private final By passwordTxt = By.id("password");
    private final By confirmPasswordTxt = By.id("confirmPassword");
    private final By passportTxt = By.id("pid");
    private final By registerButton = By.xpath("//*[@id='RegisterForm']/fieldset/p/input");

    public By getLoginLink() {
        return loginLink;
    }

    public By getConfirmationLink() {
        return confirmationLink;
    }

    public By getEmailTxt() {
        return emailTxt;
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
        BasePage.webDriver.findElement(emailTxt).sendKeys(email);
        BasePage.webDriver.findElement(passwordTxt).sendKeys(password);
        BasePage.webDriver.findElement(confirmPasswordTxt).sendKeys(confirmPassword);
        BasePage.webDriver.findElement(passportTxt).sendKeys(passportNumber);
        BasePage.webDriver.findElement(registerButton).click();
    }
}
