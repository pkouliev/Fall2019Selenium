package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup() {
        try {
            driver = DriverFactory.createDriver("chrome");
            actions = new Actions(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void hoverOnImage() {
        try {
            driver.get("http://practice.cybertekschool.com/hovers");
            driver.manage().window().maximize();
            BrowserUtils.wait(3);

            WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
            WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
            WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));


            // build() is needed when you have couple of actions
            // always end with perform()
            // pause(1000). - like Thread.sleep()
            actions.moveToElement(img1).
                    pause(1000).
                    moveToElement(img2).
                    pause(1000).
                    moveToElement(img3).
                    build().perform();

            BrowserUtils.wait(3);

            //hover on the first image
            //verify that "name: user1" is displayed
            //hover over image to make text visible
            actions.moveToElement(img1).perform();
            WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
            //verify that webelement that contains the text visible
            Assert.assertTrue(imgText1.isDisplayed());

            BrowserUtils.wait(2);

            //move to the second image
            actions.moveToElement(img2).perform();
            WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
            Assert.assertTrue(imgText2.isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void jqueryMenuTest() {
        try {
            //TASK
            driver.get("http://practice.cybertekschool.com/jqueryui/menu");
            driver.manage().window().maximize();
            BrowserUtils.wait(2);
            // hover on "enabled"
            // hover on "downloads"
            // click on PDF

            WebElement iconEnabled = driver.findElement(By.xpath("//a[contains(text(),'Enabled')]"));
            WebElement iconDownloads = driver.findElement(By.xpath("//a[contains(text(),'Downloads')]"));
            WebElement iconPDF = driver.findElement(By.xpath("//a[contains(text(),'PDF')]"));

            actions.moveToElement(iconEnabled).
                    pause(1000).
                    moveToElement(iconDownloads).
                    pause(1000).
                    click(iconPDF).
                    build().perform();

            BrowserUtils.wait(3);

            BrowserUtils.wait(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void dragAndDropTest() {
        try {
            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
            driver.manage().window().maximize();
            BrowserUtils.wait(3);

            driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
            BrowserUtils.wait(3);
            WebElement earth = driver.findElement(By.id("droptarget"));
            WebElement moon = driver.findElement(By.id("draggable"));

            actions.dragAndDrop(moon, earth).perform();

            BrowserUtils.wait(3);

            String expected = "You did great!";
            String actual = earth.getText();

            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teardown() {
        try {
            BrowserUtils.wait(3);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
