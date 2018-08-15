package com.demo.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void off() {
        driver.close();
    }

    @Test
    public void validateWebPage() {
        driver.get("blazemeter.com/blogs-on-author/");
        String errorMessage = driver.findElement(By.className("error-404")).getText();

        Assert.assertEquals("Looking for something?", errorMessage);
    }

    @Test
    public void checkLoggedInPageTitle() {
        driver.get("http://somepage.com/login");
        driver.findElement(By.className("username")).sendKeys("blaze");
        driver.findElement(By.className("username")).sendKeys("meter");
        driver.findElement(By.id("login")).click();
        String loggedInPageTitle = driver.getTitle();

        Assert.assertEquals("Success", loggedInPageTitle);
    }
}
