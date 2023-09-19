package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivity extends BasePage {
    public AccountActivity(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By overviewAccounts = By.xpath("//a[contains(text(),'Accounts Overview')]");
    private By existText = By.linkText("*Balance includes deposits that may be subject to holds");
    private By btnCuenta = By.className("ng-binding");
    private By existTextDetail = By.xpath("//a[contains(text(),'Account Details')]");
    private By btnTransaction = By.className("button");

    public void clickOverviewAccounts() throws InterruptedException {
        this.clickear(this.overviewAccounts);
    }

    public String getExistText() throws InterruptedException {
        String res = this.getText(this.existText);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    public void clickBtnCuenta() throws InterruptedException {
        this.clickear(this.btnCuenta);
    }

    public String getExistTextDetail() throws InterruptedException {
        String res = this.getText(this.existTextDetail);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    public void clickBtnTransaction() throws InterruptedException {
        this.clickear(this.btnTransaction);
    }
}
