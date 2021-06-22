package testcase;

import constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobject.BasePage;

public class BaseTest {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver",
                "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\Chrome Driver/chromedriver.exe");
        BasePage.webDriver = new ChromeDriver();
        BasePage.webDriver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Final-condition");
//        BasePage.webDriver.quit();
    }
}
