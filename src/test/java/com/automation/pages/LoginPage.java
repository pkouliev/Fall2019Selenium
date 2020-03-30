package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "prependentInput")
    public WebElement username;
//    public WebElement username2 = Driver.getDriver().findElement(By.id("prependentInput"));

    @FindBy(id = "pependentInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement login;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;


    public LoginPage() {
        //to connect our webdriver, page class and page factory
        //PageFactory - used to use @FindBy annotations
        //PageFactory - help to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Method to login, version #1
     * Login as a specific user
     *
     * @param usernameValue
     * @param passwordValue
     */
    public void Login(String usernameValue, String passwordValue) {
        this.username.sendKeys(usernameValue);
        this.password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);
    }

    /**
     * Method to login, version # 2
     * Login as a default user
     * Credentials will be retrieved from Configuration.properties file
     */
    public void Login() {
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
    }


}
