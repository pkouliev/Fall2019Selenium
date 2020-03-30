package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //same for everyone
    private static WebDriver driver;

    // so no one can create object of Driver class
    // everyone should call static getter method instead
    private Driver() {

    }

    public synchronized static WebDriver getDriver() {
        // if webdriver object doesn't exist
        // create it
        if (driver == null) {
            // specify browser type in configuration.properties file
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().version("79.0").setup();
                    driver = new ChromeDriver();
                    //driver.manage().window().maximize();
//                    driver.manage().deleteAllCookies();
//                    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
