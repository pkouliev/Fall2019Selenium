package com.automation.seleniumWebDriverDemo;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTraining {

    WebDriver driver;

    // Launching the chrome browser

    public void launchBrowser() {

        try {
            WebDriverManager.chromedriver().version("79").setup();
            driver = new ChromeDriver();
            driver.get("https://www.simplilearn.com/");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            BrowserUtils.wait(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Searching selenium training and clicking on it

    public void search() {

        try {
            driver.findElement(By.id("header_srch")).sendKeys("Selenium");
            BrowserUtils.wait(3);
            driver.findElement(By.xpath("//span[@class='search_icon input-search-icon']")).click();
            BrowserUtils.wait(3);
            driver.findElement(By.xpath("//h2[text()='Selenium 3.0 Training']")).click();
            BrowserUtils.wait(3);
            System.out.println("The page title is: " + driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Close the browser
    public void closeBrowser() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    public static void main(String[] args) {

        SearchTraining obj = new SearchTraining();
        obj.launchBrowser();
        obj.search();
        obj.closeBrowser();
    }
}
