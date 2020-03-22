package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class CalendarEventsPageTests {

    /**
     * Scenario: Verify for store manager
     * <p>
     * Login as story manager
     * Go to Activities --> Calendar Events
     * Verify that Create Calendar Event button is displayed
     */

    private By usernameBy = By.xpath("//input[@id='prependedInput']");
    private By passwordBy = By.xpath("//input[@id='prependedInput2']");
    private WebDriver driver;
    private Actions actions;

    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By calendarEventsBy = By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]");
    private By currentUserBy = By.cssSelector("#user-menu > a"); // same as  "[id=user-menu] > a"
    private By ownerBy = By.xpath("//span[@class='select2-chosen']");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");

    @BeforeMethod
    public void setup() {
        try {
            driver = DriverFactory.createDriver("chrome");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("http://qa2.vytrack.com/user/login");
            driver.manage().window().maximize();

            actions = new Actions(driver);

            BrowserUtils.wait(3);

            driver.findElement(usernameBy).sendKeys(storeManagerUserName);
            driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);

            BrowserUtils.wait(5);

            // hover over Activities
            actions.moveToElement(driver.findElement(activitiesBy)).perform();

            BrowserUtils.wait(2);

            driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]")).click();

            BrowserUtils.wait(2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyCreateCalendarEventButton() {
        WebElement calendarEvents = driver.findElement(calendarEventsBy);
        Assert.assertTrue(calendarEvents.isDisplayed());
        BrowserUtils.wait(5);
    }

    /**
     * //in the @BeforeMethod
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * <p>
     * <p>
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */
    @Test(description = "Default options")
    public void verifyDefaultValues() {
        //Click on Create Calendar Event
        driver.findElement(calendarEventsBy).click();
        BrowserUtils.wait(4);

        //Default owner name should be current user
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(currentUserName, defaultOwnerName);

        // Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());

        // date time syntax = https://www.journaldev.com/17899/java-simpledateformat-java-date-format
        // Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualDate, expectedDate);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(actualTime, expectedTime);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
