package com.nopcommerce.tests;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.ProductPage;
import com.nopcommerce.pages.CartPage;
import com.nopcommerce.utils.BaseTest;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.search("Apple MacBook Pro");
        ProductPage product = new ProductPage(driver);
        // Wait briefly to allow results to load in real runs
        Thread.sleep(2000);
        product.clickAddToCart();
        CartPage cart = new CartPage(driver);
        cart.openCart();
        cart.acceptTerms();
        // further assertions can be added to verify cart contents
    }
}
