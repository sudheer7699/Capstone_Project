package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By cartLink = By.cssSelector("a.ico-cart");
    private By termsCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver){ this.driver = driver; }

    public void openCart(){ driver.findElement(cartLink).click(); }
    public void acceptTerms(){ driver.findElement(termsCheckbox).click(); }
    public void clickCheckout(){ driver.findElement(checkoutButton).click(); }
}
