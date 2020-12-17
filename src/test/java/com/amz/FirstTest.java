package com.amz;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
    public void firstTest() {
        ChromeDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/driver/chromedriver");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//1. Go to https://www.amazon.com
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        WebElement search_box = driver.findElement(By.id("twotabsearchtextbox"));
//2. Search for "hats for men"
        search_box.sendKeys("hats for men");
        search_box.sendKeys(Keys.ENTER);
//3. Add first hat to Cart with quantity 2
        WebElement price = driver.findElement(By.className("a-price-whole"));
        price.click();
        WebElement setQnt = driver.findElement(By.id("a-autoid-9"));
        setQnt.click();
        driver.findElement(By.linkText("1")).click();
        WebElement AddToCart = driver.findElement(By.name("submit.addToCart"));
        AddToCart.click();
//4.Open cart and assert total price and quantity are correct
        driver.quit();


    }
}
