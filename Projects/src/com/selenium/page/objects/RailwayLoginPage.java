package com.selenium.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RailwayLoginPage {
    private WebDriver webDriver;
    private By byEmail = By.id("username");
    private By byPassword = By.id("password");
    private By byLoginButton = By.xpath("//*[@id=\"content\"]/form/fieldset/p/input");

    public RailwayLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public RaiwayHomePage login(String email, String password){
        webDriver.findElement(byEmail).sendKeys(email);
        webDriver.findElement(byPassword).sendKeys(password);
        webDriver.findElement(byLoginButton).click();

        return new RaiwayHomePage(webDriver);
    }
}
