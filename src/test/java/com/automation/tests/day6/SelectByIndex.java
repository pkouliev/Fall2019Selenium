package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);

        Select stateSelect = new Select(driver.findElement(By.id("state")));

        // index starts from 0
        stateSelect.selectByIndex(9); //District of Columbia perhaps
        BrowserUtils.wait(1);

        //select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);


        BrowserUtils.wait(1);
        driver.quit();
    }
}
