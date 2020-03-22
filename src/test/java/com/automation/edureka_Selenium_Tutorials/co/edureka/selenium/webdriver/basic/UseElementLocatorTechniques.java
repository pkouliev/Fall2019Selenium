package com.automation.edureka_Selenium_Tutorials.co.edureka.selenium.webdriver.basic;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UseElementLocatorTechniques {

    WebDriver driver;


    public void invokeBrowser(String url) {
        try {
            WebDriverManager.chromedriver().version("79").setup();
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.get(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elementLocatorTechniquesUsingAmazon() {
        try {
            invokeBrowser("http://www.amazon.in");
            BrowserUtils.wait(3);
            driver.findElement(By.linkText("Today's Deals")).click();
            BrowserUtils.wait(3);
            driver.navigate().back();
            BrowserUtils.wait(3);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo Laptops");
            BrowserUtils.wait(3);
            driver.findElement(By.className("nav-input")).click();
            BrowserUtils.wait(3);
            driver.navigate().back();
            driver.findElement(By.partialLinkText("Customer")).click();
            BrowserUtils.wait(3);
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

    public void elementLocatorTechniqueUsingFacebook() {
        try {
            invokeBrowser("http://facebook.com");
            BrowserUtils.wait(2);
            driver.findElement(By.name("firstname")).sendKeys("Parvin");
            BrowserUtils.wait(2);
            driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
            BrowserUtils.wait(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        UseElementLocatorTechniques obj = new UseElementLocatorTechniques();
//        obj.elementLocatorTechniquesUsingAmazon();
        obj.elementLocatorTechniqueUsingFacebook();

        obj.closeBrowser();
    }


}
