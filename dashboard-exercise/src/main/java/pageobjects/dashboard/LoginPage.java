package pageobjects.dashboard;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private final By repositoryList = By.id("repository");
    private final By usernameTxt = By.id("username");
    private final By passwordTxt = By.id("password");
    private final By loginButton = By.className("btn-login");

    public HomePage login(String repository, String username, String password){
        Select selectRepo = new Select(Constant.DRIVER.findElement(repositoryList));
        selectRepo.selectByVisibleText(repository);
        Constant.DRIVER.findElement(usernameTxt).sendKeys(username);
        Constant.DRIVER.findElement(passwordTxt).sendKeys(password);
        Constant.DRIVER.findElement(loginButton).click();
        return new HomePage();
    }
}
