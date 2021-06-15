package pageobject;

import org.openqa.selenium.By;

public class ChangePasswordPage extends BasePage {
    private final By currentPasswordTxt = By.id("currentPassword");
    private final By newPasswordTxt = By.id("newPassword");
    private final By confirmPasswordTxt = By.id("confirmPassword");
    private final By changePasswordButton = By.xpath("//*[@id='ChangePW']/fieldset/p/input");

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
        BasePage.webDriver.findElement(currentPasswordTxt).sendKeys(confirmPassword);
        BasePage.webDriver.findElement(newPasswordTxt).sendKeys(newPassword);
        BasePage.webDriver.findElement(confirmPasswordTxt).sendKeys(confirmPassword);
        BasePage.webDriver.findElement(changePasswordButton).click();
    }
}
