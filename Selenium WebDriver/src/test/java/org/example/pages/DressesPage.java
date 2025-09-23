package org.example.pages;

import org.openqa.selenium.By;

public class DressesPage extends BasePage {

    private By menuDressesLocator = By.cssSelector(".sf-menu > li:nth-child(2) > a:nth-child(1)");
    private By submenuCasulDressesLocator = By.cssSelector(".sf-menu > li:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)");
    private By titlePageCasualDressesLocator = By.className("cat-name");

    public void viewCasualDressesPage(){
        if (super.isDisplayed(menuDressesLocator)){
            super.actionMoveToElementPerform(menuDressesLocator);
            super.actionMoveToElementClickPerform(submenuCasulDressesLocator);
        } else {
            System.out.println("menu dresses was not found");
        }
    }

    public String getTitlePage(){
        return super.getText(titlePageCasualDressesLocator);
    }
}
