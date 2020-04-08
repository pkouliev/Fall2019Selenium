package com.automation.qaTesting.vyTrack.creatingVehicle;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccessVehicleInformation extends AbstractTestBase {

    // Access to VyTrack Website and verify by Page Logo.
    @Test
    public void verifyPageLogo() {
        LoginPage loginPage = new LoginPage();
        String actualLogo = driver.findElement(By.className("login-copyright")).getText();
        String expectedLogo = "© 2018 Oro, Inc. All Rights Reserved";
        Assert.assertEquals(actualLogo, expectedLogo);
        BrowserUtils.getScreenshot("VerifyPageLogo");

    }

//    loginPage.login("storemanager75", "UserUser123");
//        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
//    WebElement fleetTab = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"));
//        actions.moveToElement(fleetTab).perform();
//        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")).click();
//        BrowserUtils.getScreenshot("AllCarsPage");
}
