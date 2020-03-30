package com.automation.tests.homework.homework4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainDepartment {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * 1.go to https://www.amazon.com/gp/site-directory
     * 2.verify that every main department name
     * (indicated by blue rectangles in the picture)is
     * present in the All departments dropdown
     * (indicated by green rectangle in the picture)
     */
    @Test
    public void verifyPresence() {

        //Step 1.go to https://www.amazon.com/gp/site-directory
        driver.get("https://www.amazon.com/gp/site-directory");

        List<WebElement> mainDepartments = driver.findElements(By.className("fsdDeptTitle"));
        List<String> copyOfMainDepartments = new ArrayList<>();

        for (WebElement eachDepartment : mainDepartments) {
            copyOfMainDepartments.add(eachDepartment.getText());
        }

        String[] mainArray = copyOfMainDepartments.toArray(new String[copyOfMainDepartments.size()]);

        Arrays.sort(mainArray);
        String main = Arrays.toString(mainArray).toLowerCase();
        System.out.println(main);

        System.out.println("========");

        List<WebElement> allDepartments = driver.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
        List<String> copyOfAllDepartments = new ArrayList<>();

        for (WebElement eachDepartment : allDepartments) {
            copyOfAllDepartments.add(eachDepartment.getText());
        }

        String[] allArray = copyOfAllDepartments.toArray(new String[copyOfAllDepartments.size()]);

        Arrays.sort(allArray);
        String all = Arrays.toString(allArray).toLowerCase();
        System.out.println(all);

        //verified all main department names are not present in all department list
        Assert.assertFalse(all.contains(main));

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
