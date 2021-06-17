package common.util;

import org.openqa.selenium.JavascriptExecutor;
import pageobject.BasePage;

public class Scroll {
    public static void scrollToBottom() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BasePage.webDriver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
