package com.automation.edureka_Selenium_Tutorials;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("https://accounts.google.com");
//        driver.get("http://www.google.com");
//        WebElement username = driver.findElement(By.id("identifierId"));
//        username.sendKeys("pkouliev@gmail.com");
//        driver.findElement(By.id("identifierId")).sendKeys("pkouliev@gmail.com");
//        driver.findElement(By.name("q")).sendKeys("Selenium");
//        Thread.sleep(2000);
//        driver.findElement(By.name("btnK")).click();
//        driver.get("https://login.yahoo.com");
//        driver.findElement(By.linkText("Forgot username?")).sendKeys("pkouliev@yahoo.com");
//        driver.findElement(By.linkText("Forgot username?")).click();
//        driver.findElement(By.cssSelector("#login-username")).sendKeys("pkouliev@yahoo.com");
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("#login-signin")).click();
//        driver.findElement(By.partialLinkText("username?")).click();
//        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("pkouliev@yahoo.com");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@id='login-signin']")).click();

//        driver.get("https://classic.crmpro.com/login.cfm");
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("pkouliev");
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("1234556");
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // link: Sign Up
        // 1. //a[text()='Sign Up']
        // 2. //a[contains(text(),'Sign Up')] --> recommended

        //button:
        //button[contains(text(), 'Button 5')]
        //button[@class='btn btn-primary' and @onclick='button5()']
//        driver.get("http://practice.cybertekschool.com/multiple_buttons");
//        BrowserUtils.wait(5);
//        driver.findElement(By.xpath("//button[contains(text(), 'Button 5')]")).click();
//        BrowserUtils.wait(5);

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//button[@class='btn btn-primary' and @onclick='button5()']")).click();
        BrowserUtils.wait(5);

        driver.quit();


    }
}
