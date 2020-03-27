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

    /**
     * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. Click on “Registration Form”
     */
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

    /**
     * Step 3. Enter only one alphabetic character into first name input box.
     * Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void testCase3() {
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("h");
        WebElement warningMsg = driver.findElement(By.xpath("//small[contains(text(),'first name m')]"));
        String expectedWarningMsg = "first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(warningMsg.getText(), expectedWarningMsg);

        System.out.println("Test Case 3 passed");
    }

    /**
     * Step 3. Enter only one alphabetic character into last name input box.
     * Step 4. Verify that warning message is displayed:
     * “The last name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void testCase4() {

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("h");
        WebElement warningMsg = driver.findElement(By.xpath("//small[contains(text(),'last name m')]"));
        String expectedWarningMsg = "The last name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(warningMsg.getText(), expectedWarningMsg);

        System.out.println("Test Case 4 passed");
    }

    /**
     * Step 3. Enter any valid first name.
     * Step 4. Enter any valid last name.
     * Step 5. Enter any valid user name.
     * Step 6. Enter any valid password.
     * Step 7. Enter any valid phone number.
     * Step 8. Select gender.
     * Step 9. Enter any valid date of birth.
     * Step 10. Select any department.
     * Step 11. Enter any job title.
     * Step 12. Select java as a programming language.
     * Step 13. Click Sign up.
     * Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
     */
    @Test
    public void testCase5() {
        driver.findElement(By.xpath("//input[@placeholder='first name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("jsmith");
        driver.findElement(By.xpath("//input[@placeholder='email@email.com']")).sendKeys("jsmith@mail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234556666");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("123-456-7890");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("01/16/1996");

        driver.findElement(By.name("department")).click();
        driver.findElement(By.xpath("//option[. = 'Accounting Office']")).click();

        driver.findElement(By.name("job_title")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Scrum Master')]")).click();

        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();

        String message = driver.findElement(By.xpath("//p[contains(text(),\"You've successfully completed registration!\")]")).getText();
        String expectedMsg = "You've successfully completed registration!";

        Assert.assertEquals(message, expectedMsg);

        System.out.println("Test Case 5 passed");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
