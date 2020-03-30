package com.automation.tests.homework.homework4;


import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Links {

    /**
     * 1.go to https://www.w3schools.com/
     * 2.find all the elements in the page with the tag a
     * 3.for each of those elements, if it is displayed on the page,
     * print the text and the href of that element.
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
    public void displayElements() {
        driver.get("https://www.w3schools.com/");

        List<WebElement> href = driver.findElements(By.xpath("//a[@href]"));

        for (WebElement eachLink : href) {
            System.out.println(eachLink.getAttribute("href"));
        }

        List<WebElement> text = driver.findElements(By.xpath("//a[contains(text(),'')]"));

        for (WebElement eachText : text) {
            System.out.println(eachText.getText());
        }
    }

    @AfterMethod
    public void teardown() {
        Driver.closeDriver();
    }
}
