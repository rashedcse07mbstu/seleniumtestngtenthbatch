package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginOrangeApplication {
    public static void main(String[] args) throws InterruptedException {
        /*1. Open a browser >=
        2. Open URL -
        3. Enter User Name -
        4. Enter password -
        5. Click on login button
        6. Check the page title
        */
        //Open a browser

        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");//get Application URL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement element = driver.findElement(By.cssSelector("input.oxd-input--error"));
//        boolean elementIsDisplayed = driver.findElement(By.name("username")).isDisplayed();
        boolean elementIsDisplayed = element.isDisplayed();

        if (elementIsDisplayed) {
            element.clear();
            element.sendKeys("Admin");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        driver.findElement(By.name("password")).isDisplayed();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.quit();
    }
}
