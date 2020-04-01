package com.automation.amazonSiteTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTest extends AmazonTestBase {

    /**
     * 1.go to https://amazon.com - done in AmazonTestBase
     * 2.search for "wooden spoon"
     * 3.click search
     * 4.remember name first result that has prime label
     * 5.select Prime checkbox on the left
     * 6.verify that name first result that has prime label is same as step 4
     * 7.check the last checkbox under Brand on the left
     * 8.verify that name first result that has prime label is different
     */


    @Test
    public void verifyPrime() {

        //2.search for "wooden spoon"
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");

        //3.click search
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        //4.remember name first result that has prime label
        String primeResultBefore = driver.findElement(By.xpath("//a[@data-click-index='0']//span[@data-click-el=\"title\"]")).getText();

        //5.select Prime checkbox on the left
        driver.findElement(By.xpath("//li[@id='p_85/2470955011']//i[@class='a-icon a-icon-checkbox']")).click();

        // 6.verify that name first result that has prime label is same as step 4
        String primeResultAfter = driver.findElement(By.xpath("//a[@data-click-index='0']//span[@data-click-el=\"title\"]")).getText();
        Assert.assertEquals(primeResultAfter, primeResultBefore);

        //7.check the last checkbox under Brand on the left
        WebElement brandCheckBox = driver.findElement(By.xpath("//li[@aria-label='Scanwood']//i[@class='a-icon a-icon-checkbox']"));
        js.executeScript("arguments[0].scrollIntoView();", brandCheckBox);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@aria-label='Scanwood']//i[@class='a-icon a-icon-checkbox']")));
        brandCheckBox.click();

        //8.verify that name first result that has prime label is different
        String resultLastBrand = driver.findElement(By.xpath("//span[contains(text(),'Scanwood Olive Wood Utensil Spatula Spoon Ladle 3')]")).getText();
        Assert.assertNotEquals(resultLastBrand, primeResultAfter);
    }
}
