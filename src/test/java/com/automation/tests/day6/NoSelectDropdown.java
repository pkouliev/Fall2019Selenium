package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);

        driver.findElement(By.id("dropdownMenuLink")).click(); // to expand dropdown
        BrowserUtils.wait(1);

        //<a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
//        driver.findElement(By.linkText("Amazon")).click(); // click on option
        BrowserUtils.wait(1);

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));

        for (WebElement eachLink: allLinks) {
            System.out.println(eachLink.getText()+" : "+eachLink.getAttribute("href"));
        }

        driver.findElement(By.linkText("Etsy")).click(); // click on option
        BrowserUtils.wait(1);
        driver.quit();
    }
}
