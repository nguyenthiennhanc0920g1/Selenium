package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage {
    private final By departDateSelect = By.name("Date");
    private final By departFromSelect = By.name("DepartStation");
    private final By arriveAtSelect = By.name("ArriveStation");
    private final By seatTypeSelect = By.name("SeatType");
    private final By ticketAmountSelect = By.name("TicketAmount");
    private final By bookTicketButton = By.xpath("//*[@id='content']/div[1]/form/fieldset/input");

    public By getDepartDateSelect() {
        return departDateSelect;
    }

    public By getDepartFromSelect() {
        return departFromSelect;
    }

    public By getArriveAtSelect() {
        return arriveAtSelect;
    }

    public By getSeatTypeSelect() {
        return seatTypeSelect;
    }

    public By getTicketAmountSelect() {
        return ticketAmountSelect;
    }

    public By getBookTicketButton() {
        return bookTicketButton;
    }

    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        Select dateSelect = new Select(BasePage.webDriver.findElement(departDateSelect));
        dateSelect.selectByVisibleText(departDate);
        Select fromSelect = new Select(BasePage.webDriver.findElement(departFromSelect));
        fromSelect.selectByVisibleText(departFrom);
        Select atSelect = new Select(BasePage.webDriver.findElement(arriveAtSelect));
        atSelect.selectByVisibleText(arriveAt);
        Select seatSelect = new Select(BasePage.webDriver.findElement(seatTypeSelect));
        seatSelect.selectByVisibleText(seatType);
        Select amountSelect = new Select(BasePage.webDriver.findElement(ticketAmountSelect));
        amountSelect.selectByVisibleText(ticketAmount);
        BasePage.webDriver.findElement(bookTicketButton).click();
    }
}
