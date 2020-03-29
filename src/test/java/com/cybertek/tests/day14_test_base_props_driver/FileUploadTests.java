package com.cybertek.tests.day14_test_base_props_driver;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
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
    public void fileUploadTest() {
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
    }
}
