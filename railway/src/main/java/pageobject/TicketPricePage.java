package pageobject;

import org.openqa.selenium.By;

public class TicketPricePage extends BasePage {

    public void checkPrice(String trainFromTo) {
        By checkPriceButton = By.xpath("//li[text()='" + trainFromTo + "']/../../td/a");
        BasePage.webDriver.findElement(checkPriceButton).click();
    }

    public void matchToBookTicketPage(String trainFromTo, String seatType) {
        checkPrice(trainFromTo);
        By bookTicketButton = By.xpath("//td[text()='" + seatType + "']/../td/a");
        BasePage.webDriver.findElement(bookTicketButton).click();
    }
}
