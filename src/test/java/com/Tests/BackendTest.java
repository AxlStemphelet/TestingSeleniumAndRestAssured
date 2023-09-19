package com.Tests;

import com.Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BackendTest {

    String urlBase = "https://parabank.parasoft.com/parabank/services_proxy/bank/";
    String customerID = "12212";
    String accountID = "12212";
    String username = "user12212";
    String password = "pass12212";

    static ExtentSparkReporter info = new ExtentSparkReporter("");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void time() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    @Order(1)
    public void registro() {
        given()
                .get("https://parabank.parasoft.com/parabank/register.htm")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    @Order(2)
    public void login() {
        String response = given()
                .get("https://parabank.parasoft.com/parabank/services_proxy/bank/login/{username}/{password}", username, password)
                .then()
                .statusCode(200)
                .log().status()
                .log().body()
                .extract().asString();

        int inicial = response.indexOf("<customerId>");
        int fin = response.indexOf("</customerId>");
        String id = response.substring(inicial + 12, fin);
        System.out.println("ID: " + id);
    }

    @Test
    @Order(3)
    public void nuevaCuenta() {
        given()
                .auth()
                .basic(username, password)
                .post(urlBase + "createAccount/{customerId}/{newAccountType}/{fromAccountId}", customerID, "SAVINGS", accountID)
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }

    @Test
    @Order(4)
    public void resumenCuenta() {
        given()
                .get("https://parabank.parasoft.com/parabank/overview.htm")
                .then()
                .statusCode(404)
                .log().body();
}

    @Test
    @Order(5)
    public void fondosDetalle() {
        given()
                .auth()
                .basic(username, password)
                .get(urlBase + "getAccount/{accountId}", accountID)
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }


    @Test
    @Order(6)
    public void actividadCuenta() {
        given()
                .auth()
                .basic(username, password)
                .get(urlBase + "getTransaction/{accountId}", accountID)
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }
}
