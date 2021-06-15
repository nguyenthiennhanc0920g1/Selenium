package testcase;

import constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobject.BasePage;
import pageobject.LoginPage;

public class TestDemo {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver",
                "D:/Logigear/Training/Automation/Selenium/Selenium Jars and Drivers/Drivers" +
                        "/Chrome Driver/chromedriver.exe");
        BasePage.webDriver = new ChromeDriver();
        BasePage.webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Final-condition");
//        BasePage.webDriver.quit();
    }

    @Test
    public void TC1() {
        BasePage.webDriver.get(Constant.HOME_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.clickToElement(loginPage.getLoginTab());
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
    }
}
