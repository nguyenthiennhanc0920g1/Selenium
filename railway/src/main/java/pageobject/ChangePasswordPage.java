package pageobject;

import common.util.Scroll;
import org.openqa.selenium.By;

public class ChangePasswordPage extends BasePage {
    private final By currentPasswordTxt = By.id("currentPassword");
    private final By newPasswordTxt = By.id("newPassword");
    private final By confirmPasswordTxt = By.id("confirmPassword");
    private final By changePasswordButton = By.xpath("//input[@value='Change Password']");
    private final By title = By.xpath("//h1[text()='Change password']");
    private final By changePasswordMessage = By.xpath("//*[@id=\"ChangePW\"]/fieldset/p[1]");

    public By getTitle() {
        return title;
    }

    public By getChangePasswordMessage() {
        return changePasswordMessage;
    }

    public By getCurrentPasswordTxt() {
        return currentPasswordTxt;
    }

    public By getNewPasswordTxt() {
        return newPasswordTxt;
    }

    public By getConfirmPasswordTxt() {
        return confirmPasswordTxt;
    }

    public By getChangePasswordButton() {
        return changePasswordButton;
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        Scroll.scrollToBottom();
        BasePage.webDriver.findElement(currentPasswordTxt).sendKeys(currentPassword);
        BasePage.webDriver.findElement(newPasswordTxt).sendKeys(newPassword);
        BasePage.webDriver.findElement(confirmPasswordTxt).sendKeys(confirmPassword);
        BasePage.webDriver.findElement(changePasswordButton).click();
    }
}