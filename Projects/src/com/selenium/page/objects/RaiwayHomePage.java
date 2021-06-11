package com.selenium.page.objects;

import com.selenium.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RaiwayHomePage {
    private WebDriver webDriver;
    private By byUserNavigation = By.xpath("//h1[text()='Welcome to Safe Railway']");

    public RaiwayHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isDisplayed(){
        return Element.checkElementDisplay(webDriver, byUserNavigation, 10);
    }

}
