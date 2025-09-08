package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("button.login-button");
    private By logoutLink = By.cssSelector("a.ico-logout");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterPassword(String pwd){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(pwd);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public boolean isLoggedIn() {
        return driver.findElements(logoutLink).size() > 0;
    }
}
