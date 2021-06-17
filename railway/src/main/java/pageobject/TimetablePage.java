package pageobject;

import common.util.Scroll;
import org.openqa.selenium.By;

public class TimetablePage extends BasePage {

    public void goToCheckPricePage(String departStation, String arriveStation, String departTime, String arriveTime) {
        By checkPriceButton = By.xpath("//td[2][text()='" + departStation + "']/../td[text()='" + arriveStation + "']" +
                "/../td[text()='" + departTime + "']/../td[text()='" + arriveTime + "']/../td/a[text()='check price']");
        Scroll.scrollToBottom();
        BasePage.webDriver.findElement(checkPriceButton).click();
    }

    public void goToBookTicketPage(String departStation, String arriveStation, String departTime, String arriveTime) {
        By bookTicketButton = By.xpath("//td[2][text()='" + departStation + "']/../td[text()='" + arriveStation + "']" +
                "/../td[text()='" + departTime + "']/../td[text()='" + arriveTime + "']/../td/a[text()='book ticket']");
        Scroll.scrollToBottom();
        BasePage.webDriver.findElement(bookTicketButton).click();
    }
}
