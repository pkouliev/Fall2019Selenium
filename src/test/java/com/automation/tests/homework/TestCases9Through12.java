package com.automation.tests.homework;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases9Through12 {

    /**
     * Please use following documentation:
     * https://testng.org/doc/documentation-main.html#parameters-dataproviders
     */

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        // Step 2. And click on “Status Codes”.
        driver.findElement(By.linkText("Status Codes")).click();
    }

    /**
     * Step 3. Then collect each code links into List.
     * Step 4. Verify that following message is displayed after each code is accessed through loop statement:
     * “This page returned a (code number) status code.”
     */
    @Test
    public void testCase9Through12() {

        List<WebElement> codeLinks = driver.findElements(By.xpath("//div[@class='container']//li"));

        for (WebElement eachCode : codeLinks) {

            String codeNumber = eachCode.getText();
            eachCode.click();

            if (driver.getPageSource().contains(codeNumber)) {
                System.out.println("This page returned a " + codeNumber + " status code.");
            } else {
                System.out.println("This page did not return a " + codeNumber + " status code");
            }
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
