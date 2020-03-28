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

public class TestCases7_8 {

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
    }

    /**
     * Step 2. And click on “File Upload".
     * Step 3. Upload any file with .txt extension from your computer.
     * Step 4. Click “Upload” button.
     * Step 5. Verify that subject is: “File Uploaded!”
     * Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
     * Run this method against “Choose File” button.
     */
    @Test
    public void testCase7() {

        //Step 2. And click on “File Upload".
        driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();

        //Step 3. Upload any file with .txt extension from your computer.
        driver.findElement(By.id("file-upload")).sendKeys("/Users/Parvin/Desktop/git-practice/resume copy.txt");

        //Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();

        //Step 5. Verify that subject is: “File Uploaded!”
        WebElement subject = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]"));
        String expectedSubject = "File Uploaded!";
        Assert.assertEquals(subject.getText(), expectedSubject);

    }

    /**
     * Step 2. And click on “Autocomplete”.
     * Step 3. Enter “United States of America” into country input box.
     * Step 4. Verify that following message is displayed: “You selected: United States of America”
     */
    @Test
    public void testCase8() {

        // Step 2. And click on “Autocomplete”.
        driver.findElement(By.linkText("Autocomplete")).click();

        // Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@type='button']")).click();

        // Step 4. Verify that following message is displayed: “You selected: United States of America”
        WebElement messageActual = driver.findElement(By.cssSelector("#result"));
        String messageExpected = "You selected: United States of America";
        Assert.assertEquals(messageActual.getText(), messageExpected);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
