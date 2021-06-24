package testcase;

import common.common.Check;
import common.common.Log;
import common.util.Number;
import common.util.Scroll;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.BookTicketPage;
import pageobject.LoginPage;
import pageobject.MyTicketPage;

public class TC16 extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC16() {
        BaseTest.extentTest = BaseTest.extentReports.createTest("TC16-User can cancel a ticket");
        System.out.println("TC16-User can cancel a ticket");

        //STEP 1: Navigate to QA Railway Website
        Log.logInfo("STEP 1: Navigate to QA Railway Website.");
        BasePage.webDriver.get(Constant.HOME_URL);

        //STEP 2: Login with a valid account
        Log.logInfo("STEP 2: Login with a valid account.");
        BasePage.goToTab(BasePage.getLoginTab());
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Check.checkLoginException(Constant.USERNAME);

        //STEP 3: Book a ticket
        Log.logInfo("STEP 3: Book a ticket.");
        BasePage.goToTab(BasePage.getBookTicketTab());
        String departDate = BookTicketPage.getDepartDateRandom();
        String departFrom = BookTicketPage.getDepartFromRandom();
        String arriveAt = BookTicketPage.getArriveAtRandom();
        String seatType = BookTicketPage.getSeatTypeRandom();
        String amountTicket = Integer.toString(Number.generateRandomInt(1, 1));
        assert arriveAt != null;
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, amountTicket);
        Check.checkBookTicket(departDate, departFrom, arriveAt, seatType, amountTicket);

        //STEP 4: Click on "My ticket" tab
        Log.logInfo("STEP 4: Click on \"My ticket\" tab.");
        BasePage.goToTab(BasePage.getMyTicketTab());
        Scroll.scrollToBottom();

        //STEP 5 & STEP 6: Click on "Cancel" button of ticket which user want to cancel & Click on "OK" button on Confirmation message "Are you sure?"
        Log.logInfo("STEP 5: Click on \"Cancel\" button of ticket which user want to cancel.");
        Log.logInfo("STEP 6: Click on \"OK\" button on Confirmation message \"Are you sure?\".");
        myTicketPage.deleteTicket(departFrom, arriveAt, seatType, departDate, amountTicket);
        String errorMessage = "Delete Fail";

        //Expected Behavior: The canceled ticket is disappeared.
        Assert.assertTrue(Check.isCheckDelete(departFrom, arriveAt, seatType, departDate, amountTicket), errorMessage);
    }
}
