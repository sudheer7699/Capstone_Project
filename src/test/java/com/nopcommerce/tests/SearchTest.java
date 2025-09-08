package com.nopcommerce.tests;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.ProductPage;
import com.nopcommerce.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchExistingProduct() {
        HomePage home = new HomePage(driver);
        home.search("laptop");
        // Basic check: page title or results - placeholder
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("search") || driver.getCurrentUrl().contains("search"));
    }
}
