# SeleniumWebDriver

## Configurações do Selenium WebDriver
<p>Para configurar o Selenium usando o Java é necessário utilizar o Maven com dependências do JUnit, no arquivo pom.xml, ao criar um projeto.</p>
<p>O projeto deve conter as dependências do Selenium, no arquivo pom.xml, e os executáveis dos WebDrivers dos navegadores utilizados para os testes, inseridos em uma pasta na raiz do projeto.</p>
<p>Dessa forma, com as dependências do Selenium e do Junit, é possível escrever testes que serão executados automaticamente nos navegadores utilizando os drivers.</p>

### Técnologias utilizadas:
- Framework de Testes: Selenium, Junit 5 
- IDE: IntelliJ 
- Linguagem/Ferramenta: Java 11, Maven
- Driver: ChromeDriver, GeckoDriver
- Navegador: Chrome, Firefox

### Passo a Passo da Configuração:

1. Criar **projeto Java** utilizando **Maven Archetype** com **archetype** Java11-Junit5 do **catalog** Maven Central  
2. Instalar a biblioteca do Selenium para Java pelo Maven colando a dependência no pom.xml:

~~~java
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>${selenium.version}</version>
</dependency>
~~~

3. Instalar o(s) navegador(es) se atentando à sua versão 
4. Criar uma pasta (para os) drivers na raiz do Projeto Maven 
5. Inserir na pasta (dos) drivers os executáveis dos WebDrivers, ChromeDriver do Chrome e GeckoDriver do Firefox, conforme as versões instaladas no passo 3
- ChromeDriver: https://googlechromelabs.github.io/chrome-for-testing/known-good-versions-with-downloads.json
- GeckoDriver: https://github.com/mozilla/geckodriver/releases 

### Verificação da Configuração: Hello Selenium
<p> Para verificar se o Selenium se conectou com o WebDriver e se o WebDriver é o adequado para se conectar com o navegador:</p> 

1. No arquivo AppTest.java importar:

    `
    import static org.junit.jupiter.api.Assertions.assertTrue;
    `

    `
    import org.junit.jupiter.api.Test;
    `

- Obs: o arquivo do AppTest.java está no diretório de caminho /src/test/java/org.example, sendo org.example o nome da organização configurada na IDE 
2. Em `public void shouldAnswerWithTrue` alterar para:

~~~java
@Test
public void helloSelenium(){

    System.getProperty("webdriver.chrome.driver", "drivers/chromedriver");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.get("http://www.automationpractice.pl/index.php");
    driver.quit();

}
~~~
