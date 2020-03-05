package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        ebayTest();
       amazonTest();
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

        String[] searchSentence = searchResults.getText().split(" ");

        System.out.println(searchSentence[0]);

        //System.out.println(searchResults.getText().split(" ") [0]);

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
        driver.get("http://amazon.com");
        //enter text and clivk ENTER
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        String title = driver.getTitle();
        if (title.contains("java book")) {
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        Thread.sleep(5000);


        driver.quit();


    }

    /**
     * Go to wikipedia.org
     * enter the search term `selenium webdriver`
     * Click on the search button
     * Click on search result `Selenium (software)`
     * verify URL ends with `Selenium_(software)`
     */

    public static void wikiTest() throws Exception {

        driver = DriverFactory.createADriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        Thread.sleep(5000);


        driver.quit();

    }
}