package testcase;

import common.common.Check;
import common.util.Number;
import common.util.Scroll;
import constant.Constant;
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
        Check.checkLoginException(Constant.USERNAME);
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
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, amountTicket);
        Scroll.scrollToBottom();
        //Expected Behavior: Message "Ticket booked successfully!" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)
        Check.checkBookTicket(departDate, departFrom, arriveAt, seatType, amountTicket);
    }
}
