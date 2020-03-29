package com.automation.tests.homework.homework4;


import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

public class TodaysDate {

    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //1.go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    /**
     * 2.verify that dropdowns under Select your date of birth display current year, month,day
     */
    @Test
    public void displayDate() {

        String year = "" + LocalDate.now().getYear();
        String testYear = driver.findElement(By.xpath("//option[@value='2020']")).getText();
        Assert.assertEquals(testYear, year);

        Month month = LocalDate.now().getMonth();
        WebElement testMonth = driver.findElement(By.xpath("//option[contains(text(),'March')]"));
        Assert.assertEquals(testMonth.getText().toLowerCase(), month.toString().toLowerCase());

        String day = "" + LocalDate.now().getDayOfMonth();
        WebElement testDay = driver.findElement(By.xpath("//option[@value='29']"));
        Assert.assertEquals(testDay.getText(), day);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
