package com.nopcommerce.stepdefinitions;

import com.nopcommerce.pages.*;
import com.nopcommerce.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {
    private WebDriver driver;
    private HomePage home;
    private LoginPage login;
    private ProductPage product;
    private CartPage cart;
    private CheckoutPage checkout;

    @Given("user is logged in with email {string} and password {string}")
    public void user_is_logged_in(String email, String pwd) {
        driver = DriverFactory.initDriver("chrome");
        driver.get("https://demo.nopcommerce.com/");
        home = new HomePage(driver);
        home.clickLogin();
        login = new LoginPage(driver);
        login.enterEmail(email);
        login.enterPassword(pwd);
        login.clickLogin();
    }

    @When("user searches for {string} and adds to cart")
    public void search_and_add(String productName) throws InterruptedException {
        home.search(productName);
        Thread.sleep(2000);
        product = new ProductPage(driver);
        product.clickAddToCart();
    }

    @When("user proceeds to checkout and confirms order")
    public void proceed_checkout() throws InterruptedException {
        cart = new CartPage(driver);
        cart.openCart();
        cart.acceptTerms();
        cart.clickCheckout();
        checkout = new CheckoutPage(driver);
        checkout.continueBilling();
        Thread.sleep(1000);
        checkout.continueShippingMethod();
        Thread.sleep(1000);
        checkout.continuePaymentMethod();
        Thread.sleep(1000);
        checkout.continuePaymentInfo();
        Thread.sleep(1000);
        checkout.confirmOrder();
        Thread.sleep(1000);
        driver.quit();
    }

    @Then("order should be placed successfully")
    public void order_should_be_placed() {
        // assertions would be added here based on confirmation page
    }
}
