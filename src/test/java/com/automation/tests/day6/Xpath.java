package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(1);

        //value can be inside '' or ""
        // if you don't know the tag name, or want to skip tag name, use *
        // for example //*[@onclick='button1()'] | * means any tag name
        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();
        BrowserUtils.wait(1);

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());
        BrowserUtils.wait(1);











        BrowserUtils.wait(1);
        driver.quit();
    }
}
