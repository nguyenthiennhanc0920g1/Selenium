package pageobject;

public class LogoutPage extends BasePage {

    public void logout() {
        BasePage.webDriver.findElement(BasePage.getLogoutTab()).click();
    }
}
