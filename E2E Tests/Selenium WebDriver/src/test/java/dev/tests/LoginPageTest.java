package dev.tests;

import dev.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {

    // Cria variável loginPage para a classe LoginPage
    private LoginPage loginPage;
    // Cria variável URL para a URL
    private final String URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";

    @BeforeEach
    void setUp() throws Exception{
        // Cria variável com estrutura de localizadores e ifs da página LoginPage
        this.loginPage = new LoginPage();
        // Faz com que o driver acesse a URL da página
        this.loginPage.visit(this.URL);

    }

    @AfterEach
    void tearDown() throws Exception{
        // Encerra WebDriver após teste rodar
        this.loginPage.quitWebDriver();
    }

    @Test
    void test(){
       //when
        this.loginPage.singin();

        //then
        Assertions.assertTrue(this.loginPage.getMyAccountMessage().equals("MY ACCOUNT"));
        Assertions.assertFalse(this.loginPage.getCurrentUrl().equals(URL));
    }
}