package com.amz;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    public void setup() {

    }
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

        boolean exists = driver.findElements(By.id("a-autoid-9")).size() > 0;
        if (exists == true) {
            System.out.println("Sorry pals I little bit confused by this sites logic...");
            driver.findElement(By.className("a-dropdown-label")).click();


            driver.findElement(By.linkText("2")).click();
        } else {
            System.out.println("maybe there are no buttons:((");
        }
        WebElement AddToCart = driver.findElement(By.id("add-to-cart-button"));
        AddToCart.click();


//4.Open cart and assert total price and quantity are correct
        String number_of_goods = driver.findElement(By.id("nav-cart-count")).getText();
        System.out.println("There are " + number_of_goods + " of goods...");
        Assert.assertEquals(number_of_goods, "2");
        driver.quit();
    }

}
