package com.cybertek.tests.day7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StaleElementExample {
    public static void main(String[] args) throws InterruptedException {
        //main method to invoke thee tests
        nameMatchTest();
    }
    // each test will be a separate method
    /*
    1.open browser
    2.go to amazon
    3.search for any item
    4.remember the name of the first result
    5.click on the first result
    6.verify that product name is same in the product result
     */
    private static void nameMatchTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https:/www.amazon.com");
        String searchTerm = "disinfectant wipes";
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.ENTER);

        // FIND THE FIRST RESULT, GET TEXT, AND CLICK
        WebElement firstResult = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        String expectedName = firstResult.getText(); //Add this line to avoid StaleElementException
        firstResult.click();

        //String expectedName = firstResult.getText(); //This line throws StaleElementException

        WebElement productName = driver.findElement(By.id("productTitle"));
        String actualName = productName.getText();

        //VALIDATE
        Assert.assertEquals(expectedName, actualName);

        if(expectedName.equals(actualName)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();
    }

}
