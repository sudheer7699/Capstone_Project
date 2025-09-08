package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private By addToCartButton = By.cssSelector("button[id^='add-to-cart-button']");

    public ProductPage(WebDriver driver){ this.driver = driver; }

    public void clickAddToCart(){ driver.findElement(addToCartButton).click(); }
}
