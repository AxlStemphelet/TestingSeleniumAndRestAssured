package com.Tests;
import com.Pages.SummaryAccounts;
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

public class TestSummaryAccounts {
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
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofMillis(2000L));
        SummaryAccounts summaryAccounts = new SummaryAccounts(this.driver, this.wait);
        summaryAccounts.setup();
        summaryAccounts.url("https://parabank.parasoft.com/parabank/overview.htm");
    }

    @Test
    public void SummaryAccounts() throws InterruptedException {
        SummaryAccounts summaryAccounts = new SummaryAccounts(this.driver, this.wait);
        summaryAccounts.clickOverviewAccounts();
        summaryAccounts.getExistText();
    }

    @AfterEach
    public void cerrar() {
        SummaryAccounts summaryAccounts = new SummaryAccounts(this.driver, this.wait);
        summaryAccounts.close();
        this.extent.flush();
    }
}
