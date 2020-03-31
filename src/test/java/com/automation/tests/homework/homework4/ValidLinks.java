package com.automation.tests.homework.homework4;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidLinks {

    /**
     * 1.go to https://www.selenium.dev/documentation/en/
     * 2.find all the elements in the page with the tag a
     * 3.verify that all the links are valid
     */

    WebDriver driver;
    HttpURLConnection huc;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void verifyLinks() {

        driver.get("https://www.selenium.dev/documentation/en/");
        List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));

        for (WebElement link : links) {

            String url = link.getAttribute("href");

            if (url == null || url.isEmpty()) {
                System.out.println("URL is not valid");
                continue;
            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                int respCode = huc.getResponseCode();

                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void teardown() {
        Driver.closeDriver();
    }
}
