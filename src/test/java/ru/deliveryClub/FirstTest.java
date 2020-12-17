package ru.deliveryClub;

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
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize() ;
        WebElement search_box = driver.findElement(By.id("twotabsearchtextbox"));
        search_box.sendKeys("hats for men");
        search_box.sendKeys(Keys.ENTER);

        WebElement price = driver.findElement(By.className("a-price-whole"));
        price.click();
        WebElement setQnt = driver.findElement(By.id("a-autoid-9"));
        setQnt.click();
        driver.findElement(By.linkText("2")).click();

        WebElement AddToCart = driver.findElement(By.name("submit.addToCart"));
        AddToCart.click();

        driver.quit();


    }
}
