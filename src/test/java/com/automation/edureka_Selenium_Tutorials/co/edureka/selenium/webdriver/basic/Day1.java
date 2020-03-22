package com.automation.edureka_Selenium_Tutorials.co.edureka.selenium.webdriver.basic;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day1 {

    WebDriver driver;
//    JavascriptExecutor jse;

    public void invokeBrowser() {

        try {
            WebDriverManager.chromedriver().version("79").setup();
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            driver.get("http://www.edureka.co");
            searchCourse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchCourse() {
        driver.findElement(By.xpath("//input[@id='search-inp3']")).click();
        driver.findElement(By.xpath("//input[@id='search-inp-overlay-new']")).sendKeys("Java");
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//span[@class='typeaheadbutton']")).click();
        BrowserUtils.wait(1);
//        jse = (JavascriptExecutor)driver;
//        jse.executeScript("scroll(0, 1000)");
        driver.findElement(By.xpath("//button[@class='dropdown-toggle trackButton']")).click();
        driver.findElement(By.xpath("//label[@for='Weekend']")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//a[@class='applyfilterbtn giTrackElement']")).click();

    }

    public static void main(String[] args) {

        Day1 myObj = new Day1();
        myObj.invokeBrowser();

    }
}
