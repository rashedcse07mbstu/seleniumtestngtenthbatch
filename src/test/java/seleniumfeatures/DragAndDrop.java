package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://demoqa.com/droppable/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement dragFrom = driver.findElement(By.id("draggable"));
        WebElement dropTo = driver.findElement(By.id("droppable"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragFrom, dropTo).perform();

    }
}
