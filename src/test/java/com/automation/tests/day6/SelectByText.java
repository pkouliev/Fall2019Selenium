package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(1);

        // create a webElement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        BrowserUtils.wait(1);

        // provide webElement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        BrowserUtils.wait(1);

        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(1);

        // and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");
        BrowserUtils.wait(1);

        // select your DOB
        Select selectYear = new Select(driver.findElement(By.id("year")));
        BrowserUtils.wait(1);
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        BrowserUtils.wait(1);
        Select selectDay = new Select(driver.findElement(By.id("day")));
        BrowserUtils.wait(1);

        selectYear.selectByVisibleText("2003");
        BrowserUtils.wait(1);
        selectMonth.selectByVisibleText("February");
        BrowserUtils.wait(1);
        selectDay.selectByVisibleText("25");
        BrowserUtils.wait(1);



        // select all months one by one
        // .getOption(); - returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for(WebElement eachMonth : months) {
            //get the month name and select based on that
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(1);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        BrowserUtils.wait(1);
        stateSelect.selectByVisibleText("District Of Columbia");
        BrowserUtils.wait(1);


        // option that is currently selected
        // getFirstSelectedOption() -- returns a weblement, that's why we need to call getText()
        // getText() retrieves visible text from the webElement
        String selected = stateSelect.getFirstSelectedOption().getText();
        BrowserUtils.wait(1);
        if (selected.equals("District Of Columbia")) {
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        BrowserUtils.wait(1);








        BrowserUtils.wait(1);
        driver.quit();


    }
}
