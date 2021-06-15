package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class TimetablePage extends BasePage {

    public void goToCheckPricePage(String departStation, String arriveStation, String departTime, String arriveTime) {
        By checkPriceButton = By.xpath("//td[2][text()='" + departStation + "']/../td[text()='" + arriveStation + "']" +
                "/../td[text()='" + departTime + "']/../td[text()='" + arriveTime + "']/../td/a[text()='check price']");
        JavascriptExecutor js = (JavascriptExecutor) BasePage.webDriver;
        js.executeScript("window.scrollBy(0,350)", "");
        BasePage.webDriver.findElement(checkPriceButton).click();
    }

    public void goToBookTicketPage(String departStation, String arriveStation, String departTime, String arriveTime) {
        By bookTicketButton = By.xpath("//td[2][text()='" + departStation + "']/../td[text()='" + arriveStation + "']" +
                "/../td[text()='" + departTime + "']/../td[text()='" + arriveTime + "']/../td/a[text()='book ticket']");
        JavascriptExecutor js = (JavascriptExecutor) BasePage.webDriver;
        js.executeScript("window.scrollBy(0,350)", "");
        BasePage.webDriver.findElement(bookTicketButton).click();
    }
}
