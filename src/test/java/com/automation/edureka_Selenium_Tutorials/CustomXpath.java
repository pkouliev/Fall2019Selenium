package com.automation.edureka_Selenium_Tutorials;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CustomXpath {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Guitar");
        BrowserUtils.wait(3);
        WebElement searchIcon = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchIcon.click();


        BrowserUtils.wait(5);
        driver.quit();
    }

}
