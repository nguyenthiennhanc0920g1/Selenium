package common.common;

import org.testng.Assert;
import pageobject.BasePage;
import pageobject.BookTicketPage;
import pageobject.ChangePasswordPage;
import pageobject.RegisterPage;

public class Check {
    private static BookTicketPage bookTicketPage = new BookTicketPage();
    private static RegisterPage registerPage = new RegisterPage();
    private static ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    public static void checkRegister() {
        String actualMessage = BasePage.webDriver.findElement(registerPage.getRegisterMessage()).getText();
        String expectedMessage = "Thank you for registering your account";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
        System.out.println("Register successfully");
    }

    public static boolean isCheckLogin(String username) {
        String actualMessage = BasePage.webDriver.findElement(BasePage.getWelcomeMessage()).getText();
        String expectedMessage = "Welcome " + username;

        if (expectedMessage.equals(actualMessage)) {
            System.out.println("Login successfully");
            return true;
        } else {
            System.out.println("Login fail");
            return false;
        }
    }

    public static void checkLoginException(String username) {
        String actualMessage = BasePage.webDriver.findElement(BasePage.getWelcomeMessage()).getText();
        String expectedMessage = "Welcome " + username;
        String errorMessage = "Login fail";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
        System.out.println("Login successfully");
    }

    public static void checkBookTicket(String departDate, String departFrom, String arriveAt, String seatType, String amountTicket) {
        String actualMessage = BasePage.webDriver.findElement(bookTicketPage.getBookTicketMessage()).getText();
        String expectedMessage = "Ticket Booked Successfully!";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);

        String actualDepartDateContent = BasePage.webDriver.findElement(bookTicketPage.getDepartDateResult()).getText();
        String errorDepartDateMessage = "The Depart Date content is incorrect";
        Assert.assertEquals(actualDepartDateContent, departDate, errorDepartDateMessage);

        String actualDepartFromContent = BasePage.webDriver.findElement(bookTicketPage.getDepartFromResult()).getText();
        String errorDepartFromMessage = "The Depart From content is incorrect";
        Assert.assertEquals(actualDepartFromContent, departFrom, errorDepartFromMessage);

        String actualArriveAtContent = BasePage.webDriver.findElement(bookTicketPage.getArriveStationResult()).getText();
        String errorArriveAtMessage = "The Arrive Station content is incorrect";
        Assert.assertEquals(actualArriveAtContent, arriveAt, errorArriveAtMessage);

        String actualSeatTypeContent = BasePage.webDriver.findElement(bookTicketPage.getSeatTypeResult()).getText();
        String errorSeatTypeMessage = "The Seat Type content is incorrect";
        Assert.assertEquals(actualSeatTypeContent, seatType, errorSeatTypeMessage);

        String actualAmountTicketContent = BasePage.webDriver.findElement(bookTicketPage.getAmountTicketResult()).getText();
        String errorAmountTicketMessage = "The Amount Ticket content is incorrect";
        Assert.assertEquals(actualAmountTicketContent, amountTicket, errorAmountTicketMessage);
        System.out.println("Book Ticket successfully");
    }

    public static void checkChangePassword() {
        String actualMessage = BasePage.webDriver.findElement(changePasswordPage.getChangePasswordMessage()).getText();
        String expectedMessage = "Your password has been updated";
        String errorMessage = "The message content is incorrect";
        Assert.assertEquals(actualMessage, expectedMessage, errorMessage);
        System.out.println("Change Password successfully");
    }
}