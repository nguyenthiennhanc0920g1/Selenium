package common.check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Element {
    public static boolean checkElementDisplay(WebDriver webDriver, By by, int waitSecond) {
        for (int i = 0; i < waitSecond; i++) {
            if (webDriver.findElement(by).isDisplayed()) {
                return true;
            }
            webDriver.manage().timeouts().implicitlyWait(waitSecond, TimeUnit.SECONDS);
        }
        System.out.println("Element do not display");
        return false;
    }
}
