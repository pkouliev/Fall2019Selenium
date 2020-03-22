package com.automation.edureka_Selenium_Tutorials.co.edureka.selenium.webdriver.basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBrowserCommands {

    WebDriver driver;


    public void invokeBrowser() {
        try {
            WebDriverManager.chromedriver().version("79").setup();
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.get("http://www.yatra.com");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeBrowser() {
        try {
            //driver.close();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            TestBrowserCommands obj = new TestBrowserCommands();
            obj.invokeBrowser();
            obj.closeBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
