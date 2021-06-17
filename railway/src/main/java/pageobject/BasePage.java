package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    public static WebDriver webDriver;
    private static final By homeTab = By.xpath("//span[text()='Home']");
    private static final By FAQTab = By.xpath("//span[text()='FAQ']");
    private static final By contactTab = By.xpath("//span[text()='Contact']");
    private static final By timetableTab = By.xpath("//span[text()='Timetable']");
    private static final By ticketPriceTab = By.xpath("//span[text()='Ticket Price']");
    private static final By bookTicketTab = By.xpath("//span[text()='Book ticket']");
    private static final By myTicketTab = By.xpath("//span[text()='My ticket']");
    private static final By changePasswordTab = By.xpath("//span[text()='Change password']");
    private static final By logoutTab = By.xpath("//span[text()='Log out']");
    private static final By loginTab = By.xpath("//span[text()='Login']");
    private static final By registerTab = By.xpath("//span[text()='Register']");
    private static final By welcomeMessage = By.xpath("//*[@id=\"banner\"]/div/strong");


    public static By getHomeTab() {
        return homeTab;
    }

    public static By getFAQTab() {
        return FAQTab;
    }

    public static By getContactTab() {
        return contactTab;
    }

    public static By getTimetableTab() {
        return timetableTab;
    }

    public static By getTicketPriceTab() {
        return ticketPriceTab;
    }

    public static By getBookTicketTab() {
        return bookTicketTab;
    }

    public static By getMyTicketTab() {
        return myTicketTab;
    }

    public static By getChangePasswordTab() {
        return changePasswordTab;
    }

    public static By getLogoutTab() {
        return logoutTab;
    }

    public static By getLoginTab() {
        return loginTab;
    }

    public static By getRegisterTab() {
        return registerTab;
    }

    public static By getWelcomeMessage() {
        return welcomeMessage;
    }

    public static void goToTab(By locator) {
        webDriver.findElement(locator).click();
    }
}
