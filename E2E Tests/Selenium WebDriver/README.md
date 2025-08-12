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
2. Instalar a biblioteca do Selenium Chrome Driver, adequada ao Java, pelo Maven colando a dependência no pom.xml, com o seguinte formato:

~~~java
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>${selenium.version}</version>
</dependency>
~~~

- Biblioteca Selenium Chrome Driver: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver

- Obs: o <>conteúdo<> é alterado de acordo com a dependência e pode acusar erro porque demora para baixar

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
private WebDriver driver;

@Test
public void helloSelenium(){

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.get("http://www.automationpractice.pl/index.php");
    driver.quit();

}
~~~
- Obs: o comando `System.setProperty(key, value);` faz com que o Selenium WebDriver identifique como chave qual o browser do driver, e como valor o caminho da pasta onde o driver está. Se o arquivo do driver não possui permissão de acesso, será necessário dá-la (em alguns linux, pode usar `sudo chmod 777 nomedoarquivo`)
- Obs 2: caso dê um erro similar à "Unable to find CDP implementation matching 132", adicionar a dependência. Para acessar o cdp compatível com a versão do chrome pesquisar por devtool da versão ("selenium devtools 132"). Segue o link da 132: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-devtools-v132

### Preparando arquivo (classe) para teste no IntelliJ IDEA
1. Na pasta src/test/java/org.example criar classe chamada LoginTest
2. Para transformar o arquivo em Teste, clicar com o botão direito em cima da classe LoginTest
3. Selecionar Generate e clicar em Test..., abrirá uma janela
4. Deixar selecionado JUNIT 5 em Test Library, em Class name deixar o nome original do arquivo para sobrescrever
5. Marcar para gerar @After e @Before


## Alguns comandos do Selenium WebDriver

| Nome do comando                                                                                                                                                           | Ação do comando                                                                                                                                                                                                     |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| System.setProperty(key, value);                                                                                                                                           | Pode ser usado para identificar o browser/driver (key) e para <br/> acessar o driver pelo caminho do diretório (value)                                                                                              |
| private WebDriver variavelClasseDriver;                                                                                                                                   | Passa a classe WebDriver para a variável privada chamada variavelClasseDriver                                                                                                                                       |
| variavelClasseDriver = new ChromeDriver();                                                                                                                                | Cria um objeto referenciando a classe WebDriver (pela variável variavelClasseDriver);                                                                                                                               |
| driver.manage().window().maximize();                                                                                                                                      | Abre a janela do Browser e maximiza-a                                                                                                                                                                               |
| driver.get("URL");                                                                                                                                                        | Abre o endereço da URL na janela                                                                                                                                                                                    |
| driver.quit();                                                                                                                                                            | Finaliza/fecha o driver                                                                                                                                                                                             |
| 1. String variavelCurrentURL = driver.getCurrentURL(); <br/> 2. String variavelURL = "www.endereçourl" <br/> 3. Assertions.assertEquals(variavelURL, variavelCurrentURL); | 1. Passa na variável a URL atual pelo método driver.getCurrentURL(); do WebDriver <br/> 2. Passa a URL em uma variável <br/> 3. Compara a URL esperada (variavelURL) com a URL de acesso atual (variavelCurrentURL) |

