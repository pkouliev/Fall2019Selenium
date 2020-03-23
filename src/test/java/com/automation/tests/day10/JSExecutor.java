package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        try {
//            driver = DriverFactory.createDriver("chrome");
            WebDriverManager.chromedriver().version("79").setup();
            driver = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teardown() {
        try {
            BrowserUtils.wait(3);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scrollTest() {
        try {
            driver.get("http://practice.cybertekschool.com/infinite_scroll");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            BrowserUtils.wait(3);

            // you need to cast if reference type is WebDriver
//            JavascriptExecutor js = (JavascriptExecutor) driver;

            //scroll down 250 pixels
            // x,y coordinates
            for (int i = 0; i < 10; i++) {
                driver.executeScript("window.scrollBy(0, 250)");
                BrowserUtils.wait(1);
            }

            BrowserUtils.wait(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scrollToElementTest() {
        try {
            driver.get("http://practice.cybertekschool.com/");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            BrowserUtils.wait(2);
            WebElement endLink = driver.findElement(By.linkText("Cybertek School"));
            BrowserUtils.wait(2);
            driver.executeScript("arguments[0].scrollIntoView(true)", endLink);
            //scrollIntoView - javascript method
            // arguments[0] - means 1st webElement after comma
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
