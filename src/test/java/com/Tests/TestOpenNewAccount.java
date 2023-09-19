package com.Tests;
import com.Pages.OpenNewAccount;
import com.Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class TestOpenNewAccount {

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
        com.Pages.OpenNewAccount openNewAccount = new com.Pages.OpenNewAccount(driver, wait);
        openNewAccount.setup();
        openNewAccount.url("https://parabank.parasoft.com/parabank/openaccount.htm");
    }

    @Test
    public void OpenNewAccount() throws InterruptedException {
        OpenNewAccount openNewAccount = new com.Pages.OpenNewAccount(driver, wait);
        openNewAccount.clickButtonAccount();
        openNewAccount.clickSelectAccount();
        openNewAccount.clickSelectAccount2();
        openNewAccount.clickButtonOpenNewAccount();
        openNewAccount.getSuccess();
    }

    @AfterEach
    public void cerrar() {
        driver.quit();
    }
}
