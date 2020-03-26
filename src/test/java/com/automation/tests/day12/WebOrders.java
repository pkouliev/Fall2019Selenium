package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

    }

    /**
     * Go to web orders page
     * Click on "Check All" button
     * Verify that all records are selected
     */
    @Test
    public void checkBoxTest() {

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement eachCheckbox : checkboxes) {
            Assert.assertTrue(eachCheckbox.isSelected());
        }
    }

    /**
     * Go to web orders page
     * Verify that Steve Johns zip code is 21233
     * Then update his zip code to 20002
     * Then verify that Steve Johns zip code is 20002
     */
    @Test
    public void updateZipCode() {

        WebElement zipcode = driver.findElement(By.xpath("//td[contains(text(),'21233')]"));
        // WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));

        Assert.assertEquals(zipcode.getText(), "21233");

        // click on update edit image

        driver.findElement(By.xpath("//tr[4]//td[13]//input[1]")).click();

        WebElement zipCodeInput = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));

        zipCodeInput.clear();
        zipCodeInput.sendKeys("20002");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

        zipcode = driver.findElement(By.xpath("//td[contains(text(),'20002')]"));

        Assert.assertEquals(zipcode.getText(), "20002");

    }


    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(5);
        driver.quit();
    }

}
