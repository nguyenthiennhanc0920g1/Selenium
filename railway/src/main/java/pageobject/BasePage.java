package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    public static WebDriver webDriver;
    private final By homeTab = By.xpath("//span[text()='Home']");
    private final By FAQTab = By.xpath("//span[text()='FAQ']");
    private final By ContactTab = By.xpath("//span[text()='Contact']");
    private final By TimetableTab = By.xpath("//span[text()='Timetable']");
    private final By TicketPriceTab = By.xpath("//span[text()='Ticket Price']");
    private final By BookTicketTab = By.xpath("//span[text()='Book ticket']");
    private final By MyTicketTab = By.xpath("//span[text()='My ticket']");
    private final By ChangePasswordTab = By.xpath("//span[text()='Change password']");
    private final By LogoutTab = By.xpath("//span[text()='Log out']");
    private final By LoginTab = By.xpath("//span[text()='Login']");
    private final By RegisterTab = By.xpath("//span[text()='Register']");

    public By getHomeTab() {
        return homeTab;
    }

    public By getFAQTab() {
        return FAQTab;
    }

    public By getContactTab() {
        return ContactTab;
    }

    public By getTimetableTab() {
        return TimetableTab;
    }

    public By getTicketPriceTab() {
        return TicketPriceTab;
    }

    public By getBookTicketTab() {
        return BookTicketTab;
    }

    public By getMyTicketTab() {
        return MyTicketTab;
    }

    public By getChangePasswordTab() {
        return ChangePasswordTab;
    }

    public By getLogoutTab() {
        return LogoutTab;
    }

    public By getLoginTab() {
        return LoginTab;
    }

    public By getRegisterTab() {
        return RegisterTab;
    }

    public void clickToElement(By locator) {
        webDriver.findElement(locator).click();
    }
}
