package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByTextMultipleOptions {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);

        Select languageselect = new Select(driver.findElement(By.name("Languages")));
        //Whether this select element support selecting multiple options at the same time?
        // This is done by checking the value of "multiple" attribute.
        boolean isMultiple = languageselect.isMultiple();
        System.out.println(isMultiple);






        BrowserUtils.wait(1);
        driver.quit();
    }
}
