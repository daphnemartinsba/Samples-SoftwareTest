package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

    private WebDriver driver;

    @Test
    public void helloSelenium(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
        By variavelProcuraSelector = By.cssSelector(".sf-menu > li:nth-child(2) > a:nth-child(1)");

        driver.quit();

    }

}
