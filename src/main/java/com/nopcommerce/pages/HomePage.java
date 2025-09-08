package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginLink = By.cssSelector("a.ico-login");
    private By registerLink = By.cssSelector("a.ico-register");
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button[type='submit'][class*='search-box-button']");

    public HomePage(WebDriver driver){ this.driver = driver; }

    public void clickLogin(){ driver.findElement(loginLink).click(); }
    public void clickRegister(){ driver.findElement(registerLink).click(); }
    public void search(String query){
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchButton).click();
    }
}
