package pageobjects.dashboard;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GeneralPage {
    public static final By usernameTab = By.xpath("//a[text()='" + Constant.USERNAME + "']");
    public static final By globalSettingTab = By.xpath("//a[text()='Add Page']/../../../a");

    public static void selectGlobalSettingAction(WebDriver webDriver, String action) {
        WebElement webElement = webDriver.findElement(globalSettingTab);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).build().perform();
        webDriver.findElement(By.xpath("//a[text()='" + action + "']")).click();
    }
}
