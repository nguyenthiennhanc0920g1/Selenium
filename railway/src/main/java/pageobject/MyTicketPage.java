package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends BasePage {

    private final By departStationFilterSelect = By.name("FilterDpStation");
    private final By arriveStationFilterSelect = By.name("FilterArStation");
    private final By departDateFilterTxt = By.name("FilterDpDate");
    private final By statusFilterSelect = By.name("FilterStatus");
    private final By applyFilterButton = By.xpath("//input[@value='Apply Filter']");
    private final By title = By.xpath("//h1[text()='Manage Tickets']");

    public By getDepartStationFilterSelect() {
        return departStationFilterSelect;
    }

    public By getArriveStationFilterSelect() {
        return arriveStationFilterSelect;
    }

    public By getDepartDateFilterTxt() {
        return departDateFilterTxt;
    }

    public By getStatusFilterSelect() {
        return statusFilterSelect;
    }

    public By getApplyFilterButton() {
        return applyFilterButton;
    }

    public By getTitle() {
        return title;
    }

    public void deleteTicket(String departStation, String arriveStation, String seatType, String departDate,
                             String bookDate, String amount) {
        By deleteButton = By.xpath("//td[2][text()='" + departStation + "']/../td[text()='" + arriveStation + "']" +
                "/../td[text()='" + seatType + "']/../td[text()='" + departDate + "']/../td[text()='" + bookDate + "']" +
                "/../td[text()='" + amount + "']/../td/input");
        BasePage.webDriver.findElement(deleteButton).click();
        BasePage.webDriver.switchTo().alert().accept();
    }

    public void filterTicket(String departStation, String arriveStation, String departDate, String status) {
        Select departStationSelect = new Select(BasePage.webDriver.findElement(departStationFilterSelect));
        departStationSelect.selectByVisibleText(departStation);
        Select arriveStationSelect = new Select(BasePage.webDriver.findElement(arriveStationFilterSelect));
        arriveStationSelect.selectByVisibleText(arriveStation);
        Select statusSelect = new Select(BasePage.webDriver.findElement(statusFilterSelect));
        statusSelect.selectByVisibleText(status);
        BasePage.webDriver.findElement(departDateFilterTxt).sendKeys(departDate);
        BasePage.webDriver.findElement(applyFilterButton).click();
    }
}
