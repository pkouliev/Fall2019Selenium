package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

   //     ebayTest();
  //     amazonTest();
        wikiTest();

    }

    /**
     * Go to eBay  → 				    driver.get(“http://ebay.com”)
     * enter search term				input.sendKeys(“java book”)
     * Click on the search button		searchButton.click()
     * print number of results
     */

    public static void ebayTest() throws Exception {
        driver = DriverFactory.createDriver("chrome");

        //Go to eBay
        driver.get("http://ebay.com");

        Thread.sleep(2000);

        //enter search term

        //Click on the search button
        driver.findElement(By.id("gh-ac")).sendKeys("java book");

        Thread.sleep(2000);

        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));

        Thread.sleep(4000);

        //print number of results
        String[] searchSentence = searchResults.getText().split(" ");

        System.out.println(searchSentence[0]);

        //System.out.println(searchResults.getText().split(" ") [0]);


        driver.quit();

    }

    /**
     * Go to amazon
     * enter search term
     * Click on the search button
     * verify title contains the search term
     */

    public static void amazonTest() throws Exception{

        driver = DriverFactory.createDriver("chrome");

        //Go to amazon
        driver.get("http://amazon.com");


        //enter search term + click on the search button
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);

        Thread.sleep(4000);


        String title = driver.getTitle();

        if (title.contains("java book")) {
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        driver.quit();


    }

    /**
     * Go to wikipedia.org
     * enter the search term `selenium webdriver`
     * Click on the search button
     * click on search result `Selenium (software)`
     * verify URL ends with `Selenium_(software)`
     */

    public static void wikiTest() throws Exception {

        driver = DriverFactory.createDriver("chrome");

        // Go to wikipedia.org
        driver.get("https://en.wikipedia.org/wiki/Main_Page");


        // enter the search term `selenium webdriver` & click on the search button
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);

        //driver.findElement(By.name("go")).click();

        Thread.sleep(3000);

        //click on search result `Selenium (software)`
        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(3000);

        String link = driver.getCurrentUrl(); // to get link as a String


        //verify URL ends with `Selenium_(software)`
        if(link.endsWith("Selenium_(software)")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }
}
