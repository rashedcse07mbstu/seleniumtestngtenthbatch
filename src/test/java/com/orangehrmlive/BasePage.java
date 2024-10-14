package com.orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    public String applicationUrl = "https://opensource-demo.orangehrmlive.com/";
    public String userName = "Admin";
    public String password = "admin123";
    WebDriver driver;

    public abstract String getPageTitle();

    //Input value in Input field
    public void inputText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    //Click on any link or button
    public void clickBtn(WebElement element) {
        driver.findElement((By) element).click();
    }

    //Get text
    public String getText(By element) {
        return driver.findElement(element).getText();
    }
}
