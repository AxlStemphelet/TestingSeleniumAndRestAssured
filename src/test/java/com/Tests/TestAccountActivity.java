package com.Tests;

import com.Pages.AccountActivity;
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

public class TestAccountActivity {
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
        AccountActivity accountActivity = new AccountActivity(driver, wait);
        accountActivity.setup();
        accountActivity.url("https://parabank.parasoft.com/parabank/overview.htm");
    }

    @Test
    public void AccountActivity() throws InterruptedException {
        AccountActivity accountActivity = new AccountActivity(driver, wait);
        accountActivity.clickOverviewAccounts();
        accountActivity.getExistText();
        accountActivity.clickBtnCuenta();
        accountActivity.getExistTextDetail();
        accountActivity.clickBtnTransaction();
    }

    @AfterEach
    public void cerrar() {
        driver.quit();
    }
}
