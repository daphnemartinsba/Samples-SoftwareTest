package org.example.tests;

import org.example.pages.DressesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DressesPageTest {
    private DressesPage dressesPage;
    private String URL = "http://www.automationpractice.pl/index.php";


    @BeforeEach
    void setUp() {
        dressesPage = new DressesPage();
        dressesPage.visit(URL);
    }

    @AfterEach
    void tearDown() {
        dressesPage.quitWebDriver();
    }

    @Test
    void test(){
        //when
        this.dressesPage.viewCasualDressesPage();

        //then
        Assertions.assertEquals("CASUAL DRESSES ", this.dressesPage.getTitlePage());
        Assertions.assertFalse(this.URL.equals(dressesPage.getCurrentUrl()));

    }
}