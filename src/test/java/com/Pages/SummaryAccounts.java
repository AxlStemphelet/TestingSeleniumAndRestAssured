package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryAccounts extends BasePage {
    public SummaryAccounts(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By overviewAccounts = By.xpath("//a[contains(text(),'Accounts Overview')]");

    private By existText = By.linkText("*Balance includes deposits that may be subject to holds");

    public void clickOverviewAccounts() throws InterruptedException {
        this.clickear(this.overviewAccounts);
    }

    public String getExistText() throws InterruptedException {
        String res = this.getText(this.existText);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
}
