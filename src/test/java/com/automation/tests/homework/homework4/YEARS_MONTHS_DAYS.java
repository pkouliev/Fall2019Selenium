package com.automation.tests.homework.homework4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class YEARS_MONTHS_DAYS {

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
     * 2.select a random year under Select your date of birth
     * 3.select month January
     * 4.verify that days dropdown has current number of days
     * 5.repeat steps 3, 4 for all the months
     * NOTE: if you randomly select a leap year, verify February has 29 days
     */
    @Test
    public void verifyDays() {

        //Step 1. Choose random year, modify locator and replace year with random year data, verify results are same. And select that year.
        String randomYear = "" + ThreadLocalRandom.current().nextInt(1921, 2020);
        WebElement testYear = driver.findElement(By.xpath("//select[@id='year']//option[text()='" + randomYear + "']"));
        Assert.assertEquals(testYear.getText(), randomYear);
        testYear.click();


        //Step2. Select months in testing environment website and retrieve number of days in each month
        List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']//option"));

        ArrayList<Integer> DaysTesting = new ArrayList();


        System.out.println("Test Results Based on Website\n");

        for (WebElement eachMonth : months) {
            eachMonth.click();

            //Step 3 Get Number of Day Results for Each Month
            List<WebElement> testDays = driver.findElements(By.xpath("//select[@id='day']//option"));

            int testDaysCount = testDays.size();
            System.out.println("There are " + testDaysCount + " days in the Month of " + eachMonth.getText() + " of Year " + testYear.getText());
            DaysTesting.add(testDaysCount);

        }

        System.out.println("=========================================================================================================================");

        // Step3 Select months in using CALENDAR utility provided by Java library website and retrieve number of days in each month

        ArrayList<Integer> DaysCalendar = new ArrayList<>();

        System.out.println("Number of Days Based on Java CALENDAR UTILITY\n");

        for (int i = 0; i <= 11; i++) {

            Calendar calendar = Calendar.getInstance();
            int year = Integer.parseInt(testYear.getText());
            int date = 1;
            String monthName = new DateFormatSymbols().getMonths()[i];
            calendar.set(year, i, date);
            int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println("There are " + days + " days in the Month of " + monthName + " of Year " + testYear.getText());
            DaysCalendar.add(days);
        }

        // Step 4: Assert equality of results from testing environment and Java provided CALENDAR utilization.

        Assert.assertEquals(DaysTesting, DaysCalendar);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
