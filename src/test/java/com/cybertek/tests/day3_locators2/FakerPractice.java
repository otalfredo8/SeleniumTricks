package com.cybertek.tests.day3_locators2;

import com.github.javafaker.Faker;

public class FakerPractice {

    public static void main(String[] args) {

        //create Faker object

        Faker fakeData = new Faker();

        //I need firstname

        String name = fakeData.name().firstName();
        System.out.println(name);

        /*
        Webelement functions list
        clear()
        click()
        findElements()
        findElements()
        getAttribute()
        getLocation()
        getSize()
        getTagName()
        getText()
        isDisplayed()
        isEnable()
        isSelected()
        sendKeys()
        submit()
         */


    }
}
