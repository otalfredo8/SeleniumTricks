package com.cybertek.tests.day14_test_base_props_driver;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends TestBase {
    /*
    go to practice website
    click on file upload link
    upload a file
    click submit
    very file name is displayed in next page
     */

    @Test
    public void fileUploadTest() throws InterruptedException{
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);

        WebElement file_upload = driver.findElement(By.linkText("File Upload"));
        file_upload.click();

        WebElement fileInput = driver.findElement(By.id("file-upload"));

        fileInput.sendKeys("C:\\Users\\alfre\\Downloads\\uploadFile.txt");

        WebElement submit = driver.findElement(By.id("file-submit"));
        submit.click();
//        submit.submit();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFile.getText(), "uploadFile.txt");

    }
}
