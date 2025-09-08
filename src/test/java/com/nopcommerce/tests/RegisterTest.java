package com.nopcommerce.tests;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.RegisterPage;
import com.nopcommerce.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerNewUser() {
        HomePage home = new HomePage(driver);
        home.clickRegister();
        RegisterPage reg = new RegisterPage(driver);
        reg.selectMale();
        reg.enterFirstName("Automation");
        reg.enterLastName("User");
        String email = "autouser"+System.currentTimeMillis()+"@example.com";
        reg.enterEmail(email);
        reg.enterPassword("Password123!");
        reg.enterConfirmPassword("Password123!");
        reg.clickRegister();
        String result = reg.getResultText();
        Assert.assertTrue(result.toLowerCase().contains("completed") || result.toLowerCase().contains("thank you"));
    }
}
