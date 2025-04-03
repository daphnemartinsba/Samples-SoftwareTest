package dev.pages;


import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    /*
    * LOCATORS UTILIZADOS PELO findElement PARA ENCONTRAR OS ELEMENTOS QUE SERÃO TESTADOS
    */
    private By emailAddressLocator = By.xpath("//*[@id='email']");
    // private By emailAddressLocator = By.id("email");
    private By passwordLocator = By.name("passwd");
    private By submitBtnLocator = By.xpath("//*[@id=\"SubmitLogin\"]");
    private By tagMyAccountLocator = By.tagName("h1");

    /* Classe singIn abriga os mét-odos utilizados para realizar o login.
    * O primeiro if se o emailAddressLocator retornar que está visível, isto é, true,
    * utiliza o mét-odo type para inserir a String do email como input no locator emailAddressLocator.
    * Os demais ifs seguem o mesmo raciocínio */
    public void singin(){
        if(super.isDisplayed(emailAddressLocator)){
            super.type("rita-fernandes72@tigra.com.br", emailAddressLocator);
        } else {
            System.out.println("email textbox was not found");
        }

        if (super.isDisplayed(passwordLocator)){
            super.type("senha123", passwordLocator);
        } else {
            System.out.println("password textbox was not found");
        }

        if (super.isDisplayed(submitBtnLocator)){
            super.click(submitBtnLocator);
        } else {
            System.out.println("Sign in button was not found");
        }
    }

    public String getMyAccountMessage() {
        return super.getText(tagMyAccountLocator);
    }

}
