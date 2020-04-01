package com.automation.amazonSiteTests;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AmazonTestBase {

    protected WebDriverWait wait;
    protected Actions actions;
    protected WebDriver driver;
    protected JavascriptExecutor js;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        String URL = ConfigurationReader.getProperty("amazon");
        driver.get(URL);
        driver.manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void teardown() {
        Driver.closeDriver();
    }
}
