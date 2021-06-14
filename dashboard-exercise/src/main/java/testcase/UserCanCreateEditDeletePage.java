package testcase;

import common.check.Element;
import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.dashboard.GeneralPage;
import pageobjects.dashboard.HomePage;
import pageobjects.dashboard.LoginPage;

public class UserCanCreateEditDeletePage {
//    public static int randomNumber = (int) (Math.random() * 9000) + 1000;
//    public static String pageName = randomNumber + "2021";

    @BeforeMethod //chrome
    public void beforeMethod() {
        System.out.println("Pre-condi    tion");
        System.setProperty("webdriver.chrome.driver",
                "D:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers" +
                        "\\Chrome Driver\\chromedriver.exe");
        Constant.DRIVER = new ChromeDriver();
        Constant.DRIVER.manage().window().maximize();
    }

//    @BeforeMethod //Firefox
//    public void beforeMethod() {
//        System.out.println("Pre-condition");
//        System.setProperty("webdriver.gecko.driver", "D:\\Logigear\\Training\\" +
//                "Automation\\Selenum\\Selenium Jars and Drivers\\Drivers\\FireFox Driver\\geckodriver.exe");
//        Constant.DRIVER = new FirefoxDriver();
//        Constant.DRIVER.manage().window().maximize();
//    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
//        Constant.DRIVER.quit();
    }

    @Test(invocationCount = 1)
    public void TC001() {
        //start TC001
        System.out.println("TC001-Verify that user can add page");
        Constant.DRIVER.get(Constant.DASHBOARD_LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.REPOSITORY, Constant.USERNAME, Constant.PASSWORD);
        if (Element.checkElementDisplay(Constant.DRIVER, HomePage.usernameTab, 5)) {
            System.out.println("Login successfully!");
        } else {
            System.out.println("Login fail!");
        }
        GeneralPage.selectGlobalSettingAction(Constant.DRIVER, "Add Page");
        Element.checkElementDisplay(Constant.DRIVER, By.xpath("//h2[text()='New Page']"), 5);
        int randomNumber = (int) (Math.random() * 9000) + 1000;
        String pageName = randomNumber + "2021";
        Constant.DRIVER.findElement(By.xpath("//input[@id='name']")).sendKeys(pageName);
        Constant.DRIVER.findElement(By.xpath("//input[@id='OK']")).click();
        if (Element.checkElementDisplay(Constant.DRIVER, By.xpath("//a[text()='" + pageName + "'][@class='active']"),
                5)) {
            System.out.println("Create successfully");
        } else {
            System.out.println("Create fail");
        }
        //end TC 001
        //-------------*--------------
        //start TC002
        System.out.println("TC002-Verify that user can navigate to created page");
        Constant.DRIVER.findElement(By.xpath("//a[text()='" + pageName + "'][@class='active']")).click();
        //end TC002
        //-------------*--------------
        //start TC003
        System.out.println("TC003-Verify that user can edit the created page");
        HomePage.selectGlobalSettingAction(Constant.DRIVER, "Edit");
        Element.checkElementDisplay(Constant.DRIVER, By.xpath("//h2[text()='Edit Page']"), 5);
        Constant.DRIVER.findElement(By.xpath("//input[@id='name']")).clear();
        Constant.DRIVER.findElement(By.xpath("//input[@id='name']")).sendKeys(pageName + "_Update");
        Constant.DRIVER.findElement(By.xpath("//input[@id='OK']")).click();
        if (Element.checkElementDisplay(Constant.DRIVER, By.xpath("//a[text()='" + pageName + "_Update'][@class='active']"),
                5)) {
            System.out.println("Edit successfully");
        } else {
            System.out.println("Edit fail");
        }
        //end TC003
        //-------------*--------------
        //start TC004
        System.out.println("TC004-Verify that user can delete created page.");
        HomePage.selectGlobalSettingAction(Constant.DRIVER, "Delete");
        Constant.DRIVER.switchTo().alert().accept();
//        if (!Element.checkElementDisplay(Constant.DRIVER,
//                By.xpath("//a[text()='" + pageName + "_Update'][@class='active']"), 5)) {
//            System.out.println("Delete successfully");
//        } else {
//            System.out.println("Delete fail");
//        }
    }
}
