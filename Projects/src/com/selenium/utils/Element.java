package com.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Element {
    public static boolean checkElementDisplay(WebDriver webDriver, By by, int waitInSecond) {
        for (int i = 0; i < waitInSecond; i++) {
            try {
                if (webDriver.findElement(by).isDisplayed()) {
                    return true;
                }
                Thread.sleep(2 * 1000);
            } catch (Exception e) {
                System.out.println("waiting element for display...");
            }
        }
        return false;
    }
}
