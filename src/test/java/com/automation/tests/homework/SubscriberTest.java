package com.automation.tests.homework;


import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SubscriberTest {

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
     * Step 1. Go to "https://www.tempmailaddress.com/"
     * Step 2. Copy and save email as a string.
     * Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
     * Step 4. And click on “Sign Up For Mailing List".
     * Step 5. Enter any valid name.
     * Step 6. Enter email from the Step 2.
     * Step 7. Click Sign Up
     * Step 8. Verify that following message is displayed:
     * “Thank you for signing up. Click the button below to return to the home page.”
     * Step 9. Navigate back to the “https://www.tempmailaddress.com/”
     * Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
     * Step 11. Click on that email to open it.
     * Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
     * Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     */
    @Test
    public void subscribeTest() {

        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.xpath("//span[@id='email']")).getText();
        System.out.println(email);

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        String name = "Rashad Jacai";
        driver.findElement(By.name("full_name")).sendKeys(name);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();

        String actualMsg = driver.findElement(By.name("signup_message")).getText();
        String expectedMsg = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actualMsg, expectedMsg);
        System.out.println("Sign up message verified");

        driver.navigate().to("https://www.tempmailaddress.com/");

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table//tbody//tr[1]//td[1][contains(text(),'')]")));

        driver.findElement(By.xpath("//table//tbody//tr[1]//td[1][contains(text(),'')]")).click();


        String expectedSender = "do-not-reply@practice.cybertekschool.com";
        WebElement emailFrom = driver.findElement(By.id("odesilatel"));
        Assert.assertEquals(emailFrom.getText(), expectedSender);

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        WebElement actualSubject = driver.findElement(By.id("predmet"));
        Assert.assertEquals(actualSubject.getText(), expectedSubject);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
