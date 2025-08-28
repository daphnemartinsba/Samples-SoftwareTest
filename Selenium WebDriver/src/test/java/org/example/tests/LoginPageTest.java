package org.example.tests;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginPageTest {
    private LoginPage loginPage;
    private final String URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";

    @BeforeEach
    void setUp() throws Exception{
        loginPage = new LoginPage();
        loginPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception{
        loginPage.quitWebDriver();
    }

    @Test
    void test() {
        //when
        loginPage.signIn();
        //then
        Assertions.assertTrue(this.loginPage.getMyAccountMessage().equals("MY ACCOUNT"));
        Assertions.assertFalse(this.loginPage.getCurrentUrl().equals(this.URL));
    }
}
