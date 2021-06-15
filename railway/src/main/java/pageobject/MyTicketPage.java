package pageobject;

import org.openqa.selenium.By;

public class MyTicketPage extends BasePage {

    public void deleteTicket(String departStation, String arriveStation, String seatType, String departDate,
                             String bookDate, String amount) {
        By deleteButton = By.xpath("//td[2][text()='" + departStation + "']/../td[text()='" + arriveStation + "']" +
                "/../td[text()='" + seatType + "']/../td[text()='" + departDate + "']/../td[text()='" + bookDate + "']" +
                "/../td[text()='" + amount + "']/../td/input");
        BasePage.webDriver.findElement(deleteButton).click();
        BasePage.webDriver.switchTo().alert().accept();
    }
}
