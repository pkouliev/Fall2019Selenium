package com.automation.edureka_Selenium_Tutorials.co.edureka.selenium.webdriver.basic;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestNavigateCommands {

    WebDriver driver;
    Actions actions;

    public void invokeBrowser() {
        try {
            WebDriverManager.chromedriver().version("79").setup();
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            actions = new Actions(driver);
            navigateCommands();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigateCommands() {
        try {
            driver.navigate().to("http://www.flipkart.com");
            driver.findElement(By.xpath("//body/div/div/div/button[1]")).click();
            BrowserUtils.wait(5);
            driver.findElement(By.xpath("//span[contains(text(),'TVs & Appliances')]")).click();
            driver.findElement(By.xpath("//a[contains(text(),'Microwave Ovens')]")).click();
            BrowserUtils.wait(2);
            driver.navigate().back();
            BrowserUtils.wait(2);
            driver.navigate().forward();
            BrowserUtils.wait(2);
            driver.navigate().refresh();
            BrowserUtils.wait(5);

            actions.moveToElement(driver.findElement(By.xpath("//div[text()='More']"))).perform();
            BrowserUtils.wait(2);
            driver.findElement(By.linkText("Advertise")).click();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        TestNavigateCommands myObj = new TestNavigateCommands();
        myObj.invokeBrowser();

    }
}
