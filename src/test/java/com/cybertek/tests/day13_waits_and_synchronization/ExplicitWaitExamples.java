package com.cybertek.tests.day13_waits_and_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitExamples {

    WebDriver driver;
    // create web object
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        //TODO Webdriver Exception when "firefox" is not present
        driver = WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1TitleTest(){
        driver.get("https://google.com");
        System.out.println(driver.getTitle());

        driver.get("https://store.steampowered.com/");

        // wait for the title of the second page

        // start waiting for title contain text
        wait.until(ExpectedConditions.titleContains("Steam"));

        System.out.println(driver.getTitle());

    }

    @Test
    public void test2WaitForVisible(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        // waits for given element to be visible on page
        wait.until(ExpectedConditions.visibilityOf(username));
        // make sure that username is visible on page
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");
    }

    // THIS WILL THROW EXCEPTION
    @Test
    public void test3WaitForVisibleFail(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        //TODO - CHANGE 2 TO 20 - give no,t enough time. change the wait time
        wait.withTimeout(Duration.ofSeconds(2));

        // waits for given element to be visible on page
        wait.until(ExpectedConditions.visibilityOf(username));
        // make sure that username is visible on page
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");
    }

    @Test
    public void test4WaitForClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.tagName("button"));

        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");

        // wait for element to disappear.
        // wait until the overlay element disappears
        WebElement overlay = driver.findElement(By.className("loadingoverlay"));
        wait.until(ExpectedConditions.invisibilityOf(overlay));

        // waits for given element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

    }

    @Test
    public void test4WaitForInvisible(){
        driver.manage().window().maximize();
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();


        // wait until the element with class loader-mask is not visible
        wait.until((ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-mask.shown")))); // comment out for ElementClickInterceptException
        // click
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dashboard-column-1']//descendant::a[text()='My Calendar']"))).click();
    }


    @Test
    public void test5Fluent(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        //application server slow, network slow
        // maximum time out 30, and check every 5
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).
                pollingEvery(Duration.ofSeconds(1)).
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class);


        //wait until a certain condition
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loadingoverlay")));
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loadingoverlay")));
        driver.findElement(By.xpath("//button[text()='Submit']")).click();


    }
}
/*
WebDriverWait wait = new WebDriverWait (driver, 10);
.alertIsPresent()
.attributeContains()
.attributeToBe()
.attributeToBeNotEmpty()
.elementToBeClickable()
.elementToBeSelected()
.frameToBeAvailableAndSwitchToIt()
.invisibilityOf()
.invisibilityOfAllElements()
.visibilityOfAllElements()
.visibilityOf()
.urlToBe()
.stalenessOf()
*/