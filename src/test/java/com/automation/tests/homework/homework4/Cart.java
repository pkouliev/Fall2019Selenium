package com.automation.tests.homework.homework4;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cart {

    /**
     * 1.go to https://amazon.com
     * 2.search for "wooden spoon"
     * 3.click search
     * 4.remember the name and the price of a random result
     * 5.click on that random result
     * 6.verify default quantity of items is 1
     * 7.verify that the name and the price is the same as the one from step 5
     * 8.verify button"Add to Cart" is visible
     */

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void verifySearchResults() {

        //1.go to https://amazon.com
        driver.get("https://amazon.com");

        //2.search for "wooden spoon"
        driver.findElement(By.cssSelector("[id=twotabsearchtextbox]")).sendKeys("wooden spoon");

        //3.click search
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        Random rand = new Random();

        List<WebElement> nameResults = driver.findElements(By.xpath("//h2//a[@class]//span"));
        List<WebElement> priceResults = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        int randomIndex = rand.nextInt(nameResults.size());

        //4.remember the name and the price of a random result
        WebElement nameElement = nameResults.get(randomIndex);
        WebElement priceElement = priceResults.get(randomIndex);
        String name = nameElement.getText();
        String price = priceElement.getText();

        // 5.click on that random result
        nameElement.click();

        //6.verify default quantity of items is 1
        WebElement defaultQty = driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']//span[2]"));
        Assert.assertEquals(defaultQty.getText(), "1");

        //7.verify that the name and the price is the same as the one from step 5
        WebElement productTitleOrder = driver.findElement(By.xpath("//h1//span[@id='productTitle']"));
        WebElement priceOrder = driver.findElement(By.xpath("//div//span[@id='price_inside_buybox']"));
        String priceOrderText = priceOrder.getText();
        String priceEdited = priceOrderText.substring(1, priceOrderText.indexOf("."));
        Assert.assertEquals(productTitleOrder.getText(), name);
        Assert.assertEquals(priceEdited, price);

        //8.verify button"Add to Cart" is visible
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        Assert.assertTrue(addToCart.isDisplayed());

    }

    @AfterMethod
    public void teardown() {
        Driver.closeDriver();
    }
}
