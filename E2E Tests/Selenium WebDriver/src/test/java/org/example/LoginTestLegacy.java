package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    @AfterEach
    void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    void test(){
        // Acha o elemento do email pelo findElement e insere o endereço de email pelo sendKeys
        // WebElement emailAddressElement = driver.findElement(By.id("email"));
        WebElement emailAddressElement = driver.findElement(By.xpath("//*[@id='email']"));
        emailAddressElement.sendKeys("rita-fernandes72@tigra.com.br");

        // Acha o elemento da senha pelo findElement e insere a senha pelo sendKeys
        WebElement passwordElement = driver.findElement(By.name("passwd"));
        passwordElement.sendKeys("senha123");

        // Acha o botão de sign in pelo xpath e clica
        WebElement buttonElement = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
        buttonElement.click();

        // acha o elemento pelo tagName h1 e retorna o texto do elemento
        WebElement tagMyAccount = driver.findElement(By.tagName("h1"));
        String textMyAccount = tagMyAccount.getText();
        // Verifica se o texto retornado é o correto
        Assertions.assertTrue(textMyAccount.equals("MY ACCOUNT"));
    }

}