package com.selenium.testcases;


import com.selenium.page.objects.RailwayLoginPage;
import com.selenium.page.objects.RaiwayHomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class TestLoginRailway {

    public static void main(String[] args) {
//        String[] emailList = {"nhan123@ab.abc", "abc", "cde", "kkk", "nhan123@abc.abc"};
//        String[] passwordList = {"123123123", "12312", "ddsa", "213213", "123123123"};
//        for (int i = 0; i < emailList.length; i++) {
//            System.setProperty("webdriver.chrome.driver", "D:/Logigear/Training/Automation/Selenum" +
//                    "/Selenium Jars and Drivers/Drivers/Chrome Driver/chromedriver.exe");
//            WebDriver webDriver = new ChromeDriver();
//            webDriver.get("http://railway.somee.com/Account/Login.cshtml");
//            webDriver.manage().window().maximize();
//            RailwayLoginPage railwayLoginPage = new RailwayLoginPage(webDriver);
//            RaiwayHomePage raiwayHomePage = railwayLoginPage.login(emailList[i], passwordList[i]);
//            if (raiwayHomePage.isDisplayed()) {
//                System.out.println("Login successfully!");
//            } else {
//                System.out.println("Login fail!");
//                String url = webDriver.getCurrentUrl();
//                System.out.println(url);
//                webDriver.navigate();
//                By abc = By.xpath("abc");
//                List<WebElement> webDrivers = webDriver.findElements(abc);
//                WebElement webElement = webDriver.findElement(By.xpath("asd"));
//                webDrivers.size();
//                webDriver.quit();
//                Actions action = new Actions(webDriver);
//            }
//        }
        System.setProperty("webdriver.chrome.driver", "D:/Logigear/Training/Automation/Selenum" +
                    "/Selenium Jars and Drivers/Drivers/Chrome Driver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://railway.somee.com/Page/TrainTimeListPage.cshtml");
        WebElement webElement = webDriver.findElement(By.xpath("//tr[@class = 'TableSmallHeader']/th"));
        String abc = webElement.getAttribute("text");
        String abc1 = webElement.getText();
        List<WebElement> webElementList = webDriver.findElements(By.xpath("//tr[@class = 'TableSmallHeader']/th"));
        int indexOfTagInTrainTimetable = -1;

//        for (int i = 0; i < webElementList.size(); i++){
//            if (webElementList[i] == "Depart Station"){
//                indexOfTagInTrainTimetable = i + 1;
//            }
//        }
        System.out.println(abc);
        System.out.println(abc1);
//        System.out.println(webElementList);
//        System.out.println(webElementList.size());
    }
}

