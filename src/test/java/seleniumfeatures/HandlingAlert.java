package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class HandlingAlert {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");//get Application URL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Kudus Vai");
        alert.accept();

       String promptResult =  driver.findElement(By.id("promptResult")).getText();
       System.out.println("promptResult is :"  + promptResult);

    }
}
