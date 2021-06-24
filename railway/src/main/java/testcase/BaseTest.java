package testcase;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import common.util.Screen;
import common.util.Time;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobject.BasePage;

import java.io.IOException;

public class BaseTest {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @BeforeTest
    @Parameters("browser")
    public void setExtent(String browser) {
        String path = "E:\\Logigear\\Training\\Automation\\Selenium\\railway\\src\\reports\\" + browser + "\\" + Time.getCurrentTime() + "-reports.html";
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setDocumentTitle("Railway Automation Report");
        htmlReporter.config().setReportName("Railway Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Hostname", "Localhost");
        extentReports.setSystemInfo("OS", "Windows10");
        extentReports.setSystemInfo("Tester Name", "NhanNguyen");
        if (browser.equalsIgnoreCase("chrome")) {
            extentReports.setSystemInfo("Browser", "Chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            extentReports.setSystemInfo("Browser", "Firefox");
        } else if (browser.equalsIgnoreCase("edge")) {
            extentReports.setSystemInfo("Browser", "Edge");
        }
    }

    @AfterTest
    public void endReport() {
        extentReports.flush();
    }

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser) {
        System.out.println("Pre-condition");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\Chrome Driver/chromedriver.exe");
            BasePage.webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\FireFox Driver/geckodriver.exe");
            BasePage.webDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver",
                    "E:\\Logigear\\Training\\Automation\\Selenium\\Selenium Jars and Drivers\\Drivers\\Edge Driver/msedgedriver.exe");
            BasePage.webDriver = new EdgeDriver();
        }
        BasePage.webDriver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        BasePage.webDriver.quit();
    }

    @AfterMethod
    @Parameters("browser")
    public void tearDown(ITestResult result, String browser) {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "TESTCASE FAILED IS " + result.getName());
            extentTest.log(Status.FAIL, "TESTCASE FAILED IS " + result.getThrowable());

            String screenshotPath = Screen.getScreenshot(BasePage.webDriver, result.getName(), browser);
            try {
                extentTest.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "TESTCASE SKIPPED IS " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "TESTCASE PASSED IS " + result.getName());
        }
    }
}
