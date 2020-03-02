package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {

    public static void main(String[] args) {
        // to start selenium script we need:
        // setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        //ChromeDriver driver = new ChromeDriver();
        //RemoteWebDriver driver1 = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        // In selenium, everything starts from WebDriver interface
        driver.get("http://google.com"); // to open a website

    }
}
