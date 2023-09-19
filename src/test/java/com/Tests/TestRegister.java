package com.Tests;
import com.Pages.Register;
import com.Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class TestRegister {

    public WebDriver driver;
    public WebDriverWait wait;

    static ExtentSparkReporter info = new ExtentSparkReporter("");
    static ExtentReports extent;

    @BeforeAll
    public static void setupReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        Register register = new Register(driver, wait);
        register.setup();
        register.url("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    @Tag("REGISTER")
    public void RegistroExitoso() throws InterruptedException {
        ExtentTest test = this.extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        Register register = new Register(this.driver, this.wait);
        register.clickCrearCuenta();
        register.escribirNombre("Axl");
        register.escribirApellido("Stemphelet");
        register.escribirAddress("Calle123");
        register.escribirCity("Montevideo");
        register.escribirState("Montevideo");
        register.escribirZipCode("12345");
        register.escribirTelefono("02020202020");
        register.escribirSSN("123456");
        register.escribirUsername("dsada");
        register.escribirContrasena("123456");
        register.escribirRepetirContrasena("123456");
        register.clickRegistrarse();
        register.getExito();
    }

    @AfterEach
    public void cerrar() {
        Register register = new Register(this.driver, this.wait);
        register.close();
        this.extent.flush();
    }
}
