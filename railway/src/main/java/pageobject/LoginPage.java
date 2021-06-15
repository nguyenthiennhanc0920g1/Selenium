package pageobject;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By emailTxt = By.id("username");
    private final By passwordTxt = By.id("password");
    private final By loginButton = By.xpath("//*[@id='content']/form/fieldset/p/input");
    private final By registrationLink = By.xpath("//a[text()='Registration Page']");
    private final By forgotPasswordLink = By.xpath("//a[text()='Forgot Password page']");

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

    public void login(String username, String password) {
        BasePage.webDriver.findElement(emailTxt).sendKeys(username);
        BasePage.webDriver.findElement(passwordTxt).sendKeys(password);
        BasePage.webDriver.findElement(loginButton).click();
    }
}
