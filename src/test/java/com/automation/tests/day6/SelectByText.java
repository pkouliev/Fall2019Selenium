package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectByText {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        // create a webElement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        BrowserUtils.wait(2);

        // provide webElement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        BrowserUtils.wait(2);

        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);







        driver.quit();


    }
}
