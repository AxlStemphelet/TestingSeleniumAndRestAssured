package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register extends BasePage {
    public Register(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By nombre = By.id("customer.firstName");
    private By apellido = By.id("customer.lastName");
    private By Address = By.id("customer.address.street");
    private By City = By.id("customer.address.city");
    private By State = By.id("customer.address.state");
    private By ZipCode = By.id("customer.address.zipCode");
    private By Telephone = By.id("customer.phoneNumber");
    private By SSN = By.id("customer.ssn");
    private By btnRegistrarse = By.linkText("Register");
    private By btnCrearCuenta = By.className("button");
    private By exito = By.linkText("You are now logged in");
    private By Username = By.name("customer.username");
    private By password = By.id("customer.password");
    private By repassword = By.id("repeatedPassword");



    public void clickCrearCuenta() throws InterruptedException {
        this.clickear(this.btnRegistrarse);
    }

    public void escribirNombre(String name) throws InterruptedException {
        this.sendText(name, this.nombre);
    }

    public void escribirApellido(String name) throws InterruptedException {
        this.sendText(name, this.apellido);
    }

    public void escribirAddress(String name) throws InterruptedException {
        this.sendText(name, this.Address);
    }

    public void escribirCity(String name) throws InterruptedException {
        this.sendText(name, this.City);
    }

    public void escribirState(String name) throws InterruptedException {
        this.sendText(name, this.State);
    }

    public void escribirZipCode(String name) throws InterruptedException {
        this.sendText(name, this.ZipCode);
    }

    public void escribirTelefono(String numb) throws InterruptedException {
        this.sendText("123456789", this.Telephone);
    }

    public void escribirSSN(String numb) throws InterruptedException {
        this.sendText("123456789", this.SSN);
    }

    public void escribirUsername(String name) throws InterruptedException {
        this.sendText(name, this.Username);
    }

    public void escribirContrasena(String pass) throws InterruptedException {
        this.sendText(pass, this.password);
    }

    public void escribirRepetirContrasena(String pass) throws InterruptedException {
        this.sendText(pass, this.repassword);
    }

    public void clickRegistrarse() throws InterruptedException {
        this.clickear(this.btnCrearCuenta);
        Thread.sleep(1000L);
    }

    public String getExito() throws InterruptedException {
        return this.getText(this.exito);
    }

}

