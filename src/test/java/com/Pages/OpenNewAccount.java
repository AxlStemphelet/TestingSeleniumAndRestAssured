package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewAccount extends BasePage {
    public OpenNewAccount(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By ButtonAccount = By.xpath("//a[contains(text(),'Open New Account')]");
    private By SelectAccount = By.xpath("//select[@id='type']");
    private By SelectAccount2 = By.xpath("//select[@id='fromAccountId']");
    private By ButtonOpenNewAccount = By.xpath("//button[@class='button']");

    private By Success = By.linkText("Congratulations, your account is now open.");

    public void clickButtonAccount() throws InterruptedException {
        this.clickear(this.ButtonAccount);
    }

    public void clickSelectAccount() throws InterruptedException {
        this.clickear(this.SelectAccount);
        Thread.sleep(2000);
        WebElement listaDesplegable = driver.findElement(By.id("type"));
        Select select = new Select(listaDesplegable);
        select.selectByVisibleText("SAVINGS");
    }


    public void clickSelectAccount2() throws InterruptedException {
        this.clickear(this.SelectAccount2);
    }

    public void clickButtonOpenNewAccount() throws InterruptedException {
        this.clickear(this.ButtonOpenNewAccount);
    }

    public String getSuccess() throws InterruptedException {
        String res = this.getText(this.Success);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
}
