package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        ebayTest();
//        amazonTest();
//        wikiTest();

    }

    /**
     * Go to eBay  → 				    driver.get(“http://ebay.com”)
     * enter search term				input.sendKeys(“java book”)
     * Click on the search button		searchButton.click()
     * print number of results
     */

    public static void ebayTest() throws Exception {

        driver = DriverFactory.createADriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ") [0]);

        Thread.sleep(5000);


        driver.quit();

    }

    /**
     * Go to amazon
     * enter search term
     * Click on the search button
     * verify title contains the search term
     */

    public static void amazonTest() throws Exception{

        driver = DriverFactory.createADriver("chrome");

        Thread.sleep(5000);


        driver.quit();


    }

    public static void wikiTest() throws Exception {

        driver = DriverFactory.createADriver("chrome");

        Thread.sleep(5000);


        driver.quit();

    }
}
