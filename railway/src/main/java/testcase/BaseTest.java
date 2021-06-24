package testcase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageobject.BasePage;

public class BaseTest {

//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("Pre-condition");
//            System.setProperty("webdriver.chrome.driver",
//                    "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\Chrome Driver/chromedriver.exe");
//            BasePage.webDriver = new ChromeDriver();
//        BasePage.webDriver.manage().window().maximize();
//    }

//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("Pre-condition");
//        System.setProperty("webdriver.gecko.driver",
//                "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\FireFox Driver/geckodriver.exe");
//        BasePage.webDriver = new FirefoxDriver();
//        BasePage.webDriver.manage().window().maximize();
//    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) {
        System.out.println("Pre-condition");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\Chrome Driver/chromedriver.exe");
            BasePage.webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\FireFox Driver/geckodriver.exe");
            BasePage.webDriver = new FirefoxDriver();
        }
        BasePage.webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Final-condition");
        BasePage.webDriver.quit();
    }
}
