package com.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {

    public static void main(String[] args) throws Exception {

        /*
            1. Go to http://automationpractice.com
            2. Search for 'tshirt' in a searchbox + click enter OR click search button
            3. validate you got 'no results' message on UI
            4. Search for 't-shirt'
            5. validate there was 1 result found
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com");

        Thread.sleep(5000);

        WebElement search_box = driver.findElement(By.id("search_query_top"));
        // WebElement - Class in Selenium in java and it has many useful methods
        // .sendKeys("value that we want to send - input tag ")
        search_box.sendKeys("tshirt" + Keys.ENTER);

        /*
        <p class="alert alert-warning">
					No results were found for your search&nbsp;"tshirt"
			</p>
         */


        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        String errorText = error.getText();
        // .getText() -> returns String (text) from the element
        //System.out.println("Error message: " + errorText);
        // NoSuchElementException - it means we could not locate the element

        search_box = driver.findElement(By.id("search_query_top"));
        search_box.clear();
        // .clear() - it will delete any values from input box
        search_box.sendKeys("t-shirt" + Keys.ENTER);
        // StaleElementReferenceException - element is old/stale
        // we want to find this element again OR refresh page

        Thread.sleep(5000);

        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("items found: " + count.getText());


        driver.quit();
    }
}
