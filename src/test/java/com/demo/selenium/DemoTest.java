package com.demo.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;
import java.util.Set;

public class DemoTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void validateWebPage() {
        driver.get("blazemeter.com/blogs-on-author/");
        String errorMessage = driver.findElement(By.className("error-404")).getText();

        Assert.assertEquals("Looking for something?", errorMessage);
    }

    @Test
    public void shouldGetTitle() {
        driver.get("http://blazedemo.com/");
        String actualTitle = driver.getTitle();

        Assert.assertEquals(" BlazeDemo", actualTitle);
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

    @Test
    public void shouldHandleWindows() {
        driver.get("some url of some website");
        driver.findElement(By.id("id of element")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        String firstWindowHandler = driver.getWindowHandle();
        windowHandles.remove(firstWindowHandler);
        String tempHandle = windowHandles.iterator().next();
        if (tempHandle != firstWindowHandler) {
            String secondWindowHandler = tempHandle;
            driver.switchTo().window(secondWindowHandler);
        }

        driver.findElement(By.className("username field classname")).sendKeys("username");
        driver.findElement(By.className("password field classname")).sendKeys("password");
        driver.findElement(By.id("login button id")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals("Login done", driver.getTitle());
    }

    @Test
    public void test(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://wizzair.com");
//        System.out.println(driver.getTitle());
        if (driver.getTitle().equals("Official Wizz Air website | Book direct for the cheapest prices")){
            System.out.println("Main page title - OK!");
        } else {
            System.out.println("Main page title - Fail!");
        }

        driver.get("https://wizzair.com/en-gb/information-and-services/booking-information/how-to-book/#/");
        WebElement searchField = driver.findElement(By.name("query"));
        searchField.sendKeys("cards" + Keys.RETURN);
        List<WebElement> res = driver.findElements(By.tagName("h2"));
        for (WebElement r : res) {
            System.out.println(r.getText());
        }
        driver.close();
        driver.quit();
    }
}
