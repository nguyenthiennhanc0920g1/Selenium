package common.common;

import org.testng.Assert;
import pageobject.BasePage;

public class Check {

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
}