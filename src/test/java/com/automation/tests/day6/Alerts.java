package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(1);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click(); //to click on the first button
        BrowserUtils.wait(1);

        //to get the text from popup message
        String popupText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept(); //to click OK



        BrowserUtils.wait(1);
        driver.quit();
    }
}
