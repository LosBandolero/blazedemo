package com.demo.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.System.setProperty;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.Keys.ENTER;

public class Demo2Test {

    private WebDriver driver;

    @Before
    public void setup() {
        setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void checkGoogleComSearch() throws InterruptedException {
        driver.get("http://google.com");
        driver.findElement(By.id("lst-ib")).sendKeys("Gevorg");
        driver.findElement(By.id("lst-ib")).sendKeys(ENTER);
        WebElement element = driver.findElement(By.linkText("Gevorg - Wikipedia"));

        assertEquals("Gevorg - Wikipedia", element.getText());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
