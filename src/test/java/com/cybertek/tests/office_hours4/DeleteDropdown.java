package com.cybertek.tests.office_hours4;

import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;

public class DeleteDropdown {

    public static void main(String[] args) {

        /*
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");

        WebElement userField = driver.findElement(By.id("prependedInput"));
        WebElement passField = driver.findElement(By.id("prependedInput2"));
        WebElement logIn = driver.findElement(By.id("_submit"));

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(logIn));

        userField.sendKeys("user31");
        passField.sendKeys("UserUser123");
        logIn.click();

        WebElement fleetDrop = driver.findElement(By.xpath("//span[text()[normalize-space()='Fleet']]"));
        WebElement vServiceLogs = driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item'][5]"));

        Actions action = new Actions(driver);
        action.moveToElement(fleetDrop).perform();

        vServiceLogs.click();

        System.out.println(driver.getTitle());
         */



        Actions actions = new Actions (Driver.getDriver());

            Driver.getDriver().get("https://qa2.vytrack.com/user/login");

            WebElement userField = Driver.getDriver().findElement(By.id("prependedInput"));
            userField.sendKeys("user31");

            WebElement passField = Driver.getDriver().findElement(By.id("prependedInput2"));
            passField.sendKeys("UserUser123");

            Driver.getDriver().findElement(By.id("_submit")).click();

            WebElement fleetDrop = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));

        actions.moveToElement(fleetDrop).perform();

        Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item'][5]")).click();

            String actualUrl = Driver.getDriver().getCurrentUrl();
            String expectedUrl = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleServicesLogs";

            Assert.assertEquals(actualUrl, expectedUrl);

        /*
                if (actualUrl.equals(expectedUrl)) {
            System.out.println("VyTrack test PASSED!");
        } else {
            System.out.println("VyTrack test FAILED!!!");
        }
         */


        }
}
