package com.cybertek.tests.day8_review_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackTests_CssSelector {

    public static void main(String[] args) throws InterruptedException {
//        titleTest();
        shortcutTest();

    }
/*
Open browser
2. Go to Vytrack login page
3. Login as a sales manager
4. Verify Dashboard page is open
5. Click on Shortcuts icon
6. Click on link See full list
7. Click on link Opportunities
8. Verify Open opportunities page is open
9. Click on Shortcuts icon
10. Click on link See full list
11. Click on link Vehicle Service Logs
12. Verify error message text is You do not have
permission to perform this action.
13. Verify Shortcut Actions List page is still open

 */
    private static void shortcutTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        Thread.sleep(2000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        verifyStartsWith(expectedTitle, actualTitle);

        WebElement shortcutIcon = driver.findElement(By.cssSelector("a[title='Shortcuts']"));
        shortcutIcon.click();

        WebElement allLinks = driver.findElement(By.linkText("See full list"));
        allLinks.click();

        Thread.sleep(2000);
        WebElement opportunities = driver.findElement(By.linkText("Opportunities"));
        opportunities.click();

        Thread.sleep(2000);
        verifyStartsWith("Open Opportunities", driver.getTitle());
        //Thread.sleep(2000); //TODO add this line to avoid (ElementClickInterceptedException)
        shortcutIcon.click();
        allLinks.click();

        Thread.sleep(2000);
        WebElement vehicleServiceLogs = driver.findElement(By.linkText("Vehicle Services Logs"));
        vehicleServiceLogs.click();

        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.cssSelector(".message"));

        verifyStartsWith("You do not have permission to perform this action.", errorMessage.getText());

        verifyStartsWith("Shortcut Actions List", driver.getTitle());
        driver.quit();


    }

    private static void verifyStartsWith(String expectedTitle, String actualTitle) {
        if (actualTitle.startsWith(expectedTitle)) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }
    }

    /*
1. Open browser
2. Go to Vytrack login page
3. Login as any user
4. Click on your name on top right
5. Click on My Configuration
6. Verify that page title starts with the same name on top
right
     */
    private static void titleTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        WebElement profileName = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));

        Thread.sleep(2000);
        profileName.submit();

        Thread.sleep(1000);
        WebElement myConfiguration = driver.findElement(By.cssSelector("ul.dropdown-menu>li>a[href='/config/user/profile']"));
        myConfiguration.click();

        Thread.sleep(2000);
        String expected = profileName.getText();
        String actual = driver.getTitle();

        if (actual.startsWith(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
        driver.quit();
    }


    /*
    Goal			        CSS 3		        XPath
    All Elements		    *		            //*
    All P Elements		    p		            //p
    All Child Elements	    p>*		            //p/*
    Element By ID		    #foo		        //*[@id=’foo’]
    Element By Class	    .foo		        //*[contains(@class,’foo’)]
    Element With Attribute	*[title]	        //*[@title]
    First Child of All P	p>*:first-child	    //p/*[0]
    All P with an A child	Not possible	    //p[a]
    Next Element		    p + *		        //p/following-sibling::*[0]
    Previous Element	    Not possible	    //p/preceding-sibling::*[0]
     */

}
