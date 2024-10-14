package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.selenium.dev/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> elementList = driver.findElements(By.tagName("a"));

        for (WebElement element : elementList) {
            System.out.println("Element is:" + element.getText());
        }

    }
}
