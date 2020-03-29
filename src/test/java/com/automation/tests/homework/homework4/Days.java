package com.automation.tests.homework.homework4;


import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Days {

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
     * 1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox.
     * 2. Randomly select a checkbox.
     * As soon as you check any day, print the name of the day and uncheck immediately.
     * After you check and uncheck Friday for the third time, exit the program.
     * NOTE: Remember some checkboxes are not selectable.
     * You need to find a way to ignore them when they are randomly selected.
     * It has to be dynamic.
     * Do not hard code Saturday and Sunday.
     * Use values of certain attributes.
     */
    @Test
    public void checkingDays() {

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        //List<WebElement> days = driver.findElements(By.xpath("//input[@type='checkbox']"));

        List<WebElement> days = driver.findElements(By.xpath("//label[contains(text(),'day')]"));

        int x = 1;

        for (int i = 0; i < 100; i++) {

            Random random = new Random();
            int randomDay = random.nextInt(7);

            days.get(randomDay).click();
            // BrowserUtils.wait(2);
            days.get(randomDay).click();
            System.out.println(days.get(randomDay).getText());

            if (randomDay == 4) {
                x++;
            }

            if (x == 4) {
                break;
            }

        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}


