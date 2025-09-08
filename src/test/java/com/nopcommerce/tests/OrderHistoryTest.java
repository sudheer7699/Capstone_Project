package com.nopcommerce.tests;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoginPage;
import com.nopcommerce.pages.OrderPage;
import com.nopcommerce.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderHistoryTest extends BaseTest {

    @Test
    public void viewOrderHistory() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.enterEmail("testuser@example.com");
        login.enterPassword("Password123!");
        login.clickLogin();

        OrderPage orders = new OrderPage(driver);
        orders.goToOrders();
        Assert.assertTrue(orders.hasOrders(), "No orders found for the user");
    }
}
