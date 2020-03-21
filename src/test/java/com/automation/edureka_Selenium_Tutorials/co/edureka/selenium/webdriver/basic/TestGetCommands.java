package com.automation.edureka_Selenium_Tutorials.co.edureka.selenium.webdriver.basic;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestGetCommands {

    WebDriver driver;

    public void invokeBrowser() {
        try {
            WebDriverManager.chromedriver().version("79").setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            getCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCommands() {
        try {
            driver.get("http://www.amazon.in");
            BrowserUtils.wait(2);

            String titleOfThePage = driver.getTitle();
            System.out.println("Title of the page is: " + titleOfThePage);
            BrowserUtils.wait(2);

            driver.findElement(By.linkText("Today's Deals")).click();
            BrowserUtils.wait(2);

            String currentURL = driver.getCurrentUrl();
            System.out.println("The current URL is: " + currentURL);

            System.out.println("The current page source is: " + driver.getPageSource());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        TestGetCommands myObj = new TestGetCommands();
        myObj.invokeBrowser();
    }
}
