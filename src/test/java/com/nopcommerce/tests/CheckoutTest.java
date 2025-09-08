package com.nopcommerce.tests;

import com.nopcommerce.pages.*;
import com.nopcommerce.utils.BaseTest;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void registeredUserCheckout() throws InterruptedException {
        // Assumes user is already logged in (use LoginTest or reuse credentials)
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.enterEmail("testuser@example.com");
        login.enterPassword("Password123!");
        login.clickLogin();

        // Add product to cart
        home.search("Apple MacBook Pro");
        Thread.sleep(2000);
        ProductPage product = new ProductPage(driver);
        product.clickAddToCart();

        // Open cart and checkout
        CartPage cart = new CartPage(driver);
        cart.openCart();
        cart.acceptTerms();
        cart.clickCheckout();

        // Checkout flow - using Continue buttons to progress through steps
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.continueBilling();
        Thread.sleep(1000);
        checkout.continueShippingMethod();
        Thread.sleep(1000);
        checkout.continuePaymentMethod();
        Thread.sleep(1000);
        checkout.continuePaymentInfo();
        Thread.sleep(1000);
        checkout.confirmOrder();
        // After confirm, further assertions could verify order success
    }
}
