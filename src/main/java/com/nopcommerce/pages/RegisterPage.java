package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private By genderMale = By.id("gender-male");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By result = By.cssSelector("div.result");

    public RegisterPage(WebDriver driver){ this.driver = driver; }

    public void selectMale(){ driver.findElement(genderMale).click(); }
    public void enterFirstName(String fn){ driver.findElement(firstName).sendKeys(fn); }
    public void enterLastName(String ln){ driver.findElement(lastName).sendKeys(ln); }
    public void enterEmail(String em){ driver.findElement(email).sendKeys(em); }
    public void enterPassword(String pw){ driver.findElement(password).sendKeys(pw); }
    public void enterConfirmPassword(String pw){ driver.findElement(confirmPassword).sendKeys(pw); }
    public void clickRegister(){ driver.findElement(registerButton).click(); }
    public String getResultText(){ return driver.findElement(result).getText(); }
}
