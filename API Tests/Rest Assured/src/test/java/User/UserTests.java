package User;

import Entities.User;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTests {

    private static User user;

    public static Faker faker;
    public static RequestSpecification request;

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        faker = new Faker();

        user = new User(faker.name().username(),
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().safeEmailAddress(),
            faker.internet().password(8,10),
            faker.phoneNumber().toString());

    }

    @BeforeEach
    void setRequest(){
        request = given().config(RestAssured.config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .header("api-key", "special-key")
                //.header("Content-type", "application/json");
                .contentType(ContentType.JSON);
    }

    // Teste de criação de usuário
    @Test
    @Order(1)
    public void CreateNewUser_WithValidData_ReturnOk(){

        request
                .body(user)
                .when()
                .post("/user")
                .then()
                .assertThat().statusCode(200).and()
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", isA(String.class))
                .body("size()", equalTo(3));
    }

    // Teste de login de usuário
    @Test
    @Order(2)
    public void GetLogin_ValidUser_ReturnOK(){

        request
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .when()
                .get("/user/login")
                .then()
                .assertThat()
                .statusCode(200)
                .and().time(lessThan(2000L))
                .and().body(matchesJsonSchemaInClasspath("loginResponseSchema.json"));

    }

    // Teste de busca/validação de usuário por username
    @Test
    @Order(3)
    public void GetUserByUsername_userIsValid_ReturnOk(){

        request
                .when()
                .get("/user/" + user.getUsername())
                .then()
                .assertThat().statusCode(200).and().time(lessThan(2000L))
                .and().body("username", equalTo(user.getUsername()));
    }

    // Teste de deleção do usuário por username
    @Test
    @Order(4)
    public void DeleteUser_UserExists_ReturnOk(){

        request
                .when()
                .get("/user/" + user.getUsername())
                .then()
                .assertThat().statusCode(200).and().time(lessThan(2000L))
                .log();
    }

}
