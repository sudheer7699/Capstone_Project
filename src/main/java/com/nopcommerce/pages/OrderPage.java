package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;
    private By ordersLink = By.cssSelector("a[href='/order/history']");
    private By orderList = By.cssSelector("div.order-list");

    public OrderPage(WebDriver driver){ this.driver = driver; }

    public void goToOrders(){ driver.findElement(By.cssSelector("a.account")).click(); driver.findElement(By.linkText("Orders")).click(); }
    public boolean hasOrders(){ return driver.findElements(orderList).size() > 0; }
}
