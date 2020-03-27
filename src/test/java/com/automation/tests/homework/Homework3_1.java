package com.automation.tests.homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homework3_1 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
    }

    /**
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Enter “wrong_dob” into date of birth input box.
     * Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
    @Test
    public void testCase1() {

        driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']")).sendKeys("wrong_dob");

        WebElement actual = driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]"));
        String expected = "The date of birth is not valid";

        Assert.assertEquals(actual.getText(), expected);

        System.out.println("Test Case 1 passed");

    }

    /**
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     */
    @Test
    public void testCase2() {

        WebElement cPlusPlus = driver.findElement(By.xpath("//label[text()='C++']"));
        WebElement java = driver.findElement(By.xpath("//label[text()='Java']"));
        WebElement javaScript = driver.findElement(By.xpath("//label[text()='JavaScript']"));

        Assert.assertEquals(cPlusPlus.getText(), "C++");
        Assert.assertEquals(java.getText(), "Java");
        Assert.assertEquals(javaScript.getText(), "JavaScript");

        System.out.println("Test Case 2 passed");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
