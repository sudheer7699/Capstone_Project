package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    private By billingContinue = By.cssSelector("button[name='save']");
    private By shippingMethodContinue = By.cssSelector("button[name='save']");
    private By paymentMethodContinue = By.cssSelector("button[name='save']");
    private By paymentInfoContinue = By.cssSelector("button[name='save']");
    private By confirmOrderButton = By.cssSelector("button[type='submit'][class*='order-button']");

    public CheckoutPage(WebDriver driver){ this.driver = driver; }

    public void continueBilling(){ driver.findElement(billingContinue).click(); }
    public void continueShippingMethod(){ driver.findElement(shippingMethodContinue).click(); }
    public void continuePaymentMethod(){ driver.findElement(paymentMethodContinue).click(); }
    public void continuePaymentInfo(){ driver.findElement(paymentInfoContinue).click(); }
    public void confirmOrder(){ driver.findElement(confirmOrderButton).click(); }
}
