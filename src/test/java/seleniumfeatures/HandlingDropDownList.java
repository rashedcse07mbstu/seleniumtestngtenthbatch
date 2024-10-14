package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandlingDropDownList {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/select-menu");//get Application URL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        Select selectElement = new Select(element);
//        selectElement.selectByValue("1");
//        selectElement.selectByVisibleText("Blue");
        selectElement.selectByIndex(1);

    }
}
