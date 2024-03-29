package com.cybertek.tests.office_hours4;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;

public class CookiesExample extends TestBase {

    @Test
    public void test(){
        // PRINT SOME COOKIES
        driver.get("http://a.testaddressbook.com/addresses");
        driver.findElement(By.id("session_email")).sendKeys("kexesobepu@zsero.com");
        driver.findElement(By.id("session_password")).sendKeys("password"+ Keys.ENTER);

        System.out.println(driver.getCurrentUrl());
        // get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies.size() = " + cookies.size());
        for (Cookie cookie : cookies) {
            System.out.println(cookie.toString());
            System.out.println("--------------------------");
        }

        // delete all cookies
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());

        // PRINT COOKIES AFTER DELETION
        Set<Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("cookies2.size() = " + cookies2.size());
        for (Cookie cookie : cookies2) {
            System.out.println(cookie.toString());
            System.out.println("--------------------------");
        }

        // ADD COOKIE
        Driver.closeDriver();
        driver = Driver.getDriver();
        driver.get("http://a.testaddressbook.com/addresses");

        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
        Set<Cookie> cookies3 = driver.manage().getCookies();
        for (Cookie cookie : cookies3) {
            System.out.println(cookie.toString());
            System.out.println("--------------------------");
        }
        System.out.println(driver.getCurrentUrl());
    }
}
