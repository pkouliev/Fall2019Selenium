package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CallsPageTests {

    private By usernameBy = By.xpath("//input[@id='prependedInput']");
    private By passwordBy = By.xpath("//input[@id='prependedInput2']");
    private WebDriver driver;
    private Actions actions;


    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");

    @BeforeMethod
    public void setup() {
        try {
            driver = DriverFactory.createDriver("chrome");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("http://qa2.vytrack.com/user/login");
            driver.manage().window().maximize();

            actions = new Actions(driver);

            BrowserUtils.wait(3);

            driver.findElement(usernameBy).sendKeys(storeManagerUserName);
            driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);

            BrowserUtils.wait(5);

            // hover over Activities
            actions.moveToElement(driver.findElement(activitiesBy)).perform();

            BrowserUtils.wait(2);

            driver.findElement(By.xpath("//span[contains(text(),'Calls')]")).click();

            BrowserUtils.wait(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyLogCallButton() {
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
        Assert.assertTrue(logCallBtnElement.isDisplayed());

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
