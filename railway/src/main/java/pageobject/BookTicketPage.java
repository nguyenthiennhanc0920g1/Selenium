package pageobject;

import common.util.Number;
import common.util.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class BookTicketPage extends BasePage {
    private final By departDateSelect = By.name("Date");
    private final By departFromSelect = By.name("DepartStation");
    private final By arriveAtSelect = By.name("ArriveStation");
    private final By seatTypeSelect = By.name("SeatType");
    private final By ticketAmountSelect = By.name("TicketAmount");
    private final By bookTicketButton = By.xpath("//input[@value='Book ticket']");
    private final By bookTicketForm = By.xpath("//legend[text()='Book ticket form']");
    private final By bookTicketMessage = By.xpath("//h1[text()='Ticket Booked Successfully!']");
    private final By departFromResult = By.xpath("//td[1]");
    private final By arriveStationResult = By.xpath("//td[2]");
    private final By seatTypeResult = By.xpath("//td[3]");
    private final By departDateResult = By.xpath("//td[4]");
    private final By amountTicketResult = By.xpath("//td[7]");

    public By getDepartDateSelect() {
        return departDateSelect;
    }

    public By getDepartFromSelect() {
        return departFromSelect;
    }

    public By getBookTicketForm() {
        return bookTicketForm;
    }

    public By getDepartFromResult() {
        return departFromResult;
    }

    public By getArriveStationResult() {
        return arriveStationResult;
    }

    public By getSeatTypeResult() {
        return seatTypeResult;
    }

    public By getDepartDateResult() {
        return departDateResult;
    }

    public By getAmountTicketResult() {
        return amountTicketResult;
    }

    public By getBookTicketMessage() {
        return bookTicketMessage;
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

    public static ArrayList<String> getDepartDateList() {
        ArrayList<String> departDateList = new ArrayList<String>();
        String currentDate = (java.time.LocalDate.now()).toString();
        for (int i = 4; i < 31; i++) {
            String date = Time.IncreaseOrDecreaseDay("M/d/yyyy", currentDate, i);
            departDateList.add(date);
        }
        return departDateList;
    }

    public static String getDepartDateRandom() {
        ArrayList<String> departDateList = BookTicketPage.getDepartDateList();
        int number = Number.generateRandomInt(0, 26);
        return departDateList.get(number);
    }

    public static String getSeatTypeRandom() {
        String[] seatTypeList = new String[]{"Hard seat", "Soft seat", "Soft seat with air conditioner",
                "Hard bed", "Soft bed", "Soft bed with air conditioner"};
        int number = Number.generateRandomInt(0, 5);
        return seatTypeList[number];
    }

    public static String[] getDepartFromList() {
        return new String[]{"Sài Gòn", "Phan Thiết", "Nha Trang",
                "Đà Nẵng", "Huế", "Quảng Ngãi"};
    }

    public static String getDepartFromRandom() {
        String[] departFromList = BookTicketPage.getDepartFromList();
        int number = Number.generateRandomInt(0, 5);
        return departFromList[number];
    }

    public static String getArriveAtRandom() {
        String departFrom = BookTicketPage.getDepartFromRandom();
        String[] arriveAt = null;
        switch (departFrom) {
            case "Sài Gòn":
                arriveAt = new String[]{"Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi"};
                int number = Number.generateRandomInt(0, 4);
                return arriveAt[number];
            case "Phan Thiết":
                arriveAt = new String[]{"Sài Gòn", "Nha Trang", "Đà Nẵng"};
                number = Number.generateRandomInt(0, 2);
                return arriveAt[number];
            case "Nha Trang":
                arriveAt = new String[]{"Sài Gòn", "Phan Thiết", "Đà Nẵng", "Huế"};
                number = Number.generateRandomInt(0, 3);
                return arriveAt[number];
            case "Đà Nẵng":
                arriveAt = new String[]{"Sài Gòn", "Nha Trang", "Huế", "Quảng Ngãi"};
                number = Number.generateRandomInt(0, 3);
                return arriveAt[number];
            case "Huế":
                arriveAt = new String[]{"Sài Gòn", "Nha Trang", "Đà Nẵng", "Quảng Ngãi"};
                number = Number.generateRandomInt(0, 3);
                return arriveAt[number];
            case "Quảng Ngãi":
                arriveAt = new String[]{"Sài Gòn", "Nha Trang", "Đà Nẵng", "Huế"};
                number = Number.generateRandomInt(0, 3);
                return arriveAt[number];
            default:
                System.out.println("Error list");
                return null;
        }
    }
}
