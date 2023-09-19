package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFunds extends BasePage {
    public TransferFunds(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By btnTransferencia = By.xpath("//a[contains(text(),'Transfer Funds')]");
    private By existTexto = By.linkText("Transfer Funds");
    private By importe = By.xpath("//input[@id='amount']");
    private By Account = By.xpath("//select[@id='fromAccountId']");
    private By toAccount = By.xpath("//select[@id='toAccountId']");
    private By btnTransfer = By.xpath("//button[@class='button']");
    private By Success = By.linkText("Transfer Complete!");

    public void clickBtnTransferencia() throws InterruptedException {
        this.clickear(this.btnTransferencia);
    }

    public String getExistTexto() throws InterruptedException {
        String res = this.getText(this.existTexto);
        System.out.println("Resultado Card value: " + res);
        return res;
    }

    public void setImporte(double importe) throws InterruptedException {
        this.getNumb(this.importe);
    }

    public void setAccount() throws InterruptedException {
        this.clickear(this.Account);
        Thread.sleep(2000);
        this.clickear(this.Account);
    }

    public void setToAccount() throws InterruptedException {
        this.clickear(this.toAccount);
        Thread.sleep(2000);
        this.clickear(this.toAccount);
    }

    public void clickBtnTransfer() throws InterruptedException {
        this.clickear(this.btnTransfer);
    }

    public String getSuccess() throws InterruptedException {
        String res = this.getText(this.Success);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
}
