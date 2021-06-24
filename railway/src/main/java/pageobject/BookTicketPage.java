package pageobject;

import common.util.Number;
import common.util.Scroll;
import common.util.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BookTicketPage extends BasePage {
    private static String departFrom = "";
    private final By departDateSelectBox = By.name("Date");
    private final By departFromSelectBox = By.name("DepartStation");
    private final By arriveAtSelectBox = By.name("ArriveStation");
    private final By seatTypeSelectBox = By.name("SeatType");
    private final By ticketAmountSelectBox = By.name("TicketAmount");
    private final By departFromSelected = By.xpath("//select[@name='DepartStation']/option[@selected='selected']");
    private final By arriveAtSelected = By.xpath("//select[@name='ArriveStation']/option[@selected='selected']");
    private final By bookTicketButton = By.xpath("//input[@value='Book ticket']");
    private final By bookTicketForm = By.xpath("//legend[text()='Book ticket form']");
    private final By bookTicketMessage = By.xpath("//h1[text()='Ticket Booked Successfully!']");
    private final By departFromResult = By.xpath("//td[1]");
    private final By arriveStationResult = By.xpath("//td[2]");
    private final By seatTypeResult = By.xpath("//td[3]");
    private final By departDateResult = By.xpath("//td[4]");
    private final By amountTicketResult = By.xpath("//td[7]");

    public static String getDepartFrom() {
        return departFrom;
    }

    public By getDepartDateSelectBox() {
        return departDateSelectBox;
    }

    public By getDepartFromSelectBox() {
        return departFromSelectBox;
    }

    public By getArriveAtSelectBox() {
        return arriveAtSelectBox;
    }

    public By getSeatTypeSelectBox() {
        return seatTypeSelectBox;
    }

    public By getTicketAmountSelectBox() {
        return ticketAmountSelectBox;
    }

    public By getDepartFromSelected() {
        return departFromSelected;
    }

    public By getArriveAtSelected() {
        return arriveAtSelected;
    }

    public By getBookTicketButton() {
        return bookTicketButton;
    }

    public By getBookTicketForm() {
        return bookTicketForm;
    }

    public By getBookTicketMessage() {
        return bookTicketMessage;
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

    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        Scroll.scrollToBottom();
        Select dateSelect = new Select(BasePage.webDriver.findElement(departDateSelectBox));
        dateSelect.selectByVisibleText(departDate);
        Select fromSelect = new Select(BasePage.webDriver.findElement(departFromSelectBox));
        fromSelect.selectByVisibleText(departFrom);
        BasePage.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        BasePage.webDriver.findElement(By.xpath("//span[@id='ArriveStation']/select/option[text()='" + arriveAt + "']"));
        Time.waitLoadContent(5000);
        Select atSelect = new Select(BasePage.webDriver.findElement(arriveAtSelectBox));
        atSelect.selectByVisibleText(arriveAt);
        Select seatSelect = new Select(BasePage.webDriver.findElement(seatTypeSelectBox));
        seatSelect.selectByVisibleText(seatType);
        Select amountSelect = new Select(BasePage.webDriver.findElement(ticketAmountSelectBox));
        amountSelect.selectByVisibleText(ticketAmount);
        BasePage.webDriver.findElement(bookTicketButton).click();
    }

    public static ArrayList<String> getDepartDateList() {
        ArrayList<String> departDateList = new ArrayList<String>();
        String currentDate = (java.time.LocalDate.now()).toString();
        for (int i = 4; i < 30; i++) {
            String date = Time.increaseOrDecreaseDay("M/d/yyyy", currentDate, i);
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
        return BookTicketPage.departFrom = departFromList[number];
    }

    public static String getArriveAtRandom() {
        String[] arriveAt = null;
        switch (BookTicketPage.departFrom) {
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
