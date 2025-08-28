package org.example.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private By emailAddressLocator = By.id("email");
    private By passwordLocator = By.name("passwd");
    private By submitBtnLocator = By.xpath("//*[@id=\"SubmitLogin\"]");
    private By tagMyAccountLocator = By.tagName("h1");

    public void signIn() {
        if (super.isDisplayed(emailAddressLocator)) { // if driver can find email's textbox
            super.type("rita-fernandes72@tigra.com.br", emailAddressLocator); // insert email address
            super.type("senha123", passwordLocator); // insert login password
            super.click(submitBtnLocator); // click on login button
        } else {
            System.out.println("Email's textbox not found"); // caso o driver não encontre o campo de email, retorna mensagem "Email's textbox not found"
        }
    }

    public String getMyAccountMessage() {
        return super.getText(tagMyAccountLocator);
    }
}
