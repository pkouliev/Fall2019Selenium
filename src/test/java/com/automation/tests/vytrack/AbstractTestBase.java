package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTestBase {


    // will be visible in the subclass, regarless of subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    protected WebDriver driver;
    protected JavascriptExecutor js;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        String URL = ConfigurationReader.getProperty("qa1");
        driver.get(URL);
        driver.manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
        js = (JavascriptExecutor) driver;

    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) {
        //ItestResult class describes the result of a test.
        // if test failed, take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            // screenshot will have a name of the test
            BrowserUtils.getScreenshot(iTestResult.getName());
        }
        Driver.closeDriver();
    }
}
