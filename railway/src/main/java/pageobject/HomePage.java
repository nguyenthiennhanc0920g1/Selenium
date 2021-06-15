package pageobject;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By welcomeText = By.xpath("//h1[text()='Welcome to Safe Railway']");
    private final By createAccountLink = By.xpath("//a[text()='create an account']");

    public By getWelcomeText() {
        return welcomeText;
    }

    public By getCreateAccountLink() {
        return createAccountLink;
    }
}
