package testcase;

import common.common.Check;
import common.util.Scroll;
import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.BookTicketPage;
import pageobject.LoginPage;
import pageobject.TimetablePage;

public class TC15 extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private TimetablePage timetablePage = new TimetablePage();
    private BookTicketPage bookTicketPage = new BookTicketPage();

    @Test
    public void TC15() {
        System.out.println("TC15-User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        //STEP 1: Navigate to QA Railway Website
        BasePage.webDriver.get(Constant.HOME_URL);
        //STEP 2: Login with a valid account
        BasePage.goToTab(BasePage.getLoginTab());
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Check.checkLoginException(Constant.USERNAME);
        //STEP 3: Click on "Timetable" tab
        BasePage.goToTab(BasePage.getTimetableTab());
        //STEP 4: Click on "book ticket" link of the route
        String departFrom = BookTicketPage.getDepartFromRandom();
        String arriveAt = BookTicketPage.getArriveAtRandom();
        timetablePage.goToBookTicketPage(departFrom, arriveAt);
        Scroll.scrollToBottom();
        //Expected Behavior: "Book ticket" page is loaded with correct  "Depart from" and "Arrive at" values.
        String actualDepartFromContent = BasePage.webDriver.findElement(bookTicketPage.getDepartFromSelected()).getText();
        String errorDepartFromMessage = "The Depart From content is incorrect";
        Assert.assertEquals(actualDepartFromContent, departFrom, errorDepartFromMessage);

        String actualArriveAtContent = BasePage.webDriver.findElement(bookTicketPage.getArriveAtSelected()).getText();
        String errorArriveAtMessage = "The Arrive Station content is incorrect";
        Assert.assertEquals(actualArriveAtContent, arriveAt, errorArriveAtMessage);
    }
}
