package com.Tests;
import com.Pages.TransferFunds;
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

public class TestTransferFunds {
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
        TransferFunds transferFunds = new TransferFunds(this.driver, this.wait);
        transferFunds.setup();
        transferFunds.url("https://parabank.parasoft.com/parabank/transfer.htm");
    }

    @Test
    public void TransferFunds() throws InterruptedException {
        TransferFunds transferFunds = new TransferFunds(this.driver, this.wait);
        transferFunds.clickBtnTransferencia();
        transferFunds.getExistTexto();
        transferFunds.setImporte(100);
        transferFunds.setAccount();
        transferFunds.setToAccount();
        transferFunds.clickBtnTransfer();
        transferFunds.getSuccess();
    }

    @AfterEach
    public void cerrar() {
        TransferFunds transferFunds = new TransferFunds(this.driver, this.wait);
        transferFunds.close();
        this.extent.flush();
    }
}
