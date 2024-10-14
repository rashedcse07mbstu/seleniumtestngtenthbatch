package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class HandlingRadioButton {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.guru99.com/test/radio.html");//get Application URL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("vfb-7-2")).isSelected();
        driver.findElement(By.id("vfb-7-2")).click();

        //Select Checkbox
        driver.findElement(By.id("vfb-6-2")).isSelected();
        driver.findElement(By.id("vfb-6-2")).click();

    }

}
