package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {


    /**
     * Login and verify that page title is "Dashboard"
     */
    @Test
    public void verifyPageTitle() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }

    /**
     * Enter wrong credentials and verify warning message
     */

    @Test
    public void verifyWarningMessage() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessage(), "Invalid user name or password.");

        //take a screenshot
        BrowserUtils.getScreenshot("warning_message");
    }

}
