package testcase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageobject.BasePage;

public class BaseTest {
    @BeforeClass
    public void beforeClass() {
//        System.out.println("Pre-condition");
//        System.setProperty("webdriver.chrome.driver",
//                "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\Chrome Driver/chromedriver.exe");
//        BasePage.webDriver = new ChromeDriver();
//        BasePage.webDriver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
//        System.out.println("Final-condition");
//        BasePage.webDriver.quit();
    }

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\Chrome Driver/chromedriver.exe");
            BasePage.webDriver = new ChromeDriver();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver",
                "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\Chrome Driver/chromedriver.exe");
        BasePage.webDriver = new ChromeDriver();
        BasePage.webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Final-condition");
        BasePage.webDriver.quit();
    }
}
