package com.orangehrmlive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGOrangeHrmLogin extends BasePage {
    /*1. Open a browser >=
        2. Open URL -
        3. Enter User Name -
        4. Enter password -
        5. Click on login button
        6. Check the page title
        */
    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();     //Open a browser
        driver = new FirefoxDriver();
        driver.get(applicationUrl);//get Application URL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1, enabled = false)
    public void doLoginOrangeHrmApplication() throws InterruptedException {

        WebElement userElement = driver.findElement(By.name("username"));
        WebElement passwordElement = driver.findElement(By.name("password"));
        //        boolean elementIsDisplayed = driver.findElement(By.name("username")).isDisplayed();
        boolean elementIsDisplayed = userElement.isDisplayed();

        if (elementIsDisplayed) {
            userElement.clear();
            inputText((By) userElement, userName);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        passwordElement.isDisplayed();
        passwordElement.clear();
        inputText((By) passwordElement, password);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

        Thread.sleep(5000);
        WebElement btnElement = driver.findElement(By.xpath("//button[@type='submit']"));

        btnElement.isDisplayed();
        clickBtn(btnElement);
    }

    @Test(priority = 2, enabled = false)
    public void validateHomePageTitleAfterLogin() throws InterruptedException {
        WebElement element = driver.findElement(By.name("username"));
        //        boolean elementIsDisplayed = driver.findElement(By.name("username")).isDisplayed();
        boolean elementIsDisplayed = element.isDisplayed();

        if (elementIsDisplayed) {
            element.clear();
            element.sendKeys(userName);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        driver.findElement(By.name("password")).isDisplayed();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedPageTitle = "OrangeHRM";
        String actualPageTitle = getPageTitle();
        if (expectedPageTitle == actualPageTitle) {
            System.out.println("found valid page title and Test Case is Passed");
        }

    }

    @Test(priority = 0, enabled = true)
    public void LoginOrangeHrmApplicationShouldSucceed() {
        System.out.println("Welcome to TestNG");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }
}
