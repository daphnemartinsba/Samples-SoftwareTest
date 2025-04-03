package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

    @Test
    public void helloSelenium() {
        //https://www.selenium.dev/documentation/webdriver/drivers/
        // Pega o driver do chrome driver na pasta drivers/chromedriver
        System.getProperty("webdriver.chrome.driver", "drivers/chromedriver");
        // Cria um driver do ChromeDriver chamado driver
        WebDriver driver = new ChromeDriver();
        // Comando do Selenium para o driver abrir o chrome maximizado
        driver.manage().window().maximize();
        // Comando do Selenium para o driver navegar até a URL
        driver.get("http://www.automationpractice.pl/index.php");

        // Encerra o driver
        driver.quit();

    }

}
