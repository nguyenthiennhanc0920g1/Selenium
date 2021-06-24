package common.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screen {
    public static String getScreenshot(WebDriver driver, String screenshotName, String browser) {
        String dateName = Time.getCurrentTime();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = "E:\\Logigear\\Training\\Automation\\Selenium\\railway\\src\\screenshots\\" + browser + "\\" + screenshotName + "-" + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
