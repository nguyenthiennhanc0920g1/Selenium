package testcase;

import common.util.Number;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.BookTicketPage;
import pageobject.LoginPage;

public class TC14 extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();

    @Test
    public void TC14() {
        System.out.println("TC14-User can book 1 ticket at a time");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Login with a valid account
        BasePage.goToTab(BasePage.getLoginTab());
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        //STEP 3: Click on "Book ticket" tab
        BasePage.goToTab(BasePage.getBookTicketTab());
        //STEP 4: Select a "Depart date" from the list
        //STEP 5: Select a "Depart from" from the list
        //STEP 6: Select a "Arrive at" from the list
        //STEP 7: Select a "Seat type" from the list
        //STEP 8: Select a "Ticket amount" from the list
        String departDate = BookTicketPage.getDepartDateRandom();
        String departFrom = BookTicketPage.getDepartFromRandom();
        String arriveAt = BookTicketPage.getArriveAtRandom();
        String seatType = BookTicketPage.getSeatTypeRandom();
        String amountTicket = Integer.toString(Number.generateRandomInt(1, 1));

        System.out.println(departDate);
        System.out.println(departFrom);
        System.out.println(arriveAt);
        System.out.println(seatType);
        System.out.println(amountTicket);

        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, amountTicket);
        //Expected Behavior: Message "Ticket booked successfully!" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)
        String actualMessage = BasePage.webDriver.findElement(bookTicketPage.getBookTicketMessage()).getText();
        String expectedMessage = "Ticket booked successfully!";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);

        String actualDepartDateContent = BasePage.webDriver.findElement(bookTicketPage.getDepartDateResult()).getText();
        String errorDepartDateMessage = "The content is incorrect";
        Assert.assertEquals(actualMessage, departDate, errorMessage);

        String actualDepartFromContent = BasePage.webDriver.findElement(bookTicketPage.getDepartFromResult()).getText();
        String errorDepartFromMessage = "The content is incorrect";
        Assert.assertEquals(actualMessage, departFrom, errorMessage);

        String actualArriveAtContent = BasePage.webDriver.findElement(bookTicketPage.getArriveStationResult()).getText();
        String errorArriveAtMessage = "The content is incorrect";
        Assert.assertEquals(actualMessage, arriveAt, errorMessage);

        String actualSeatTypeContent = BasePage.webDriver.findElement(bookTicketPage.getSeatTypeResult()).getText();
        String errorSeatTypeMessage = "The content is incorrect";
        Assert.assertEquals(actualMessage, seatType, errorMessage);

        String actualAmountTicketContent = BasePage.webDriver.findElement(bookTicketPage.getAmountTicketResult()).getText();
        String errorAmountTicketMessage = "The content is incorrect";
        Assert.assertEquals(actualMessage, amountTicket, errorMessage);
    }
}
