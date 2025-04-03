package dev.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BasePage {
    private WebDriver driver;

    public BasePage() {
        //https://www.selenium.dev/documentation/webdriver/drivers/
        // Seta o driver do chrome driver na pasta drivers/chromedriver
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        // Cria um driver do ChromeDriver chamado driver
        driver = new ChromeDriver();
        // Comando do Selenium para o driver abrir o chrome maximizado
        driver.manage().window().maximize();
    }

    // Entrada de dados: Quando chama o mét-odo visit, a variável url é passada, essa variável será inserida na url do driver
    public void visit(String url){
        this.driver.get(url);
    }

    // Saída de dados: Pega a URL atual onde o driver está
    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    // Encerra driver
    public void quitWebDriver(){
        this.driver.quit();
    }

    // Mét-odo findElement do WebElement que deve receber um By.locator (identificado pela variável locator)
    public WebElement findElement(By locator){
        return this.driver.findElement(locator);
    }

    /*
    * INPUTS QUE ATUAM NOS ELEMENTOS ENCONTRADOS PELO MÉT-ODO public WebElement findElement(By locator){}
    * */

    // Mét-odo faz o INPUT (ação) DE STRINGS sobre o elemento encontrado pelo driver: Ex: Insere (input) endereço de email em um campo de email encontrado pelo locator
    public void type(String input, By locator){
        this.driver.findElement(locator).sendKeys(input);
    }

    // Mét-odo que verifica se um elemento (rastreado pela variável locator) está visível (isDisplayed) em uma página, retorna true ou false
    public Boolean isDisplayed(By locator){
        try{
            // verifica se elemento é visível pelo mét-odo .isDisplayed do WebElement do selenium
            return this.driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    // Faz input .click() no elemento encontrado pelo findElement e armazenado na variável locator. Ou seja, encontra o elemento buscado por findElement e clica nele.
    public void click(By locator){
        this.driver.findElement(locator).click();
    }

    // Acessa pelo getText o texto encontrado pelo findElement
    public String getText(By locator){
        return this.driver.findElement(locator).getText();
    }

}
