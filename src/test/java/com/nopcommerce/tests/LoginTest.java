package com.nopcommerce.tests;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoginPage;
import com.nopcommerce.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.enterEmail("testuser@example.com");
        login.enterPassword("Password123!");
        login.clickLogin();
        Assert.assertTrue(login.isLoggedIn(), "Login failed - logout link not found");
    }
}
