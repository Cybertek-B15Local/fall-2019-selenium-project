package com.cybertek.tests.office_hours1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleSearchTest {
    /*
    Open browser
2. Go to https://google.com
3. Search for one of the strings the list searchStrs given below
4. In the results pages, capture the url right above the first result
5. Click on the first result
6. Verify that url is equal to the value from step 4
7. Navigate back
8. Repeat the same steps for all search items in the list
Note: Do this exercise using a for loop. Here is the list that was mentioned step 3:
List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", “Selenium web browser automation" );
     */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");

        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation" );
//        List<String> searchStrs = Arrays.asList("Java");

        for (String searchStr : searchStrs) {
            WebElement searchInput = driver.findElement(By.name("q"));
            // this is for setting up the 2 and 3 rd loop
            searchInput.clear();
            searchInput.sendKeys(searchStr + Keys.ENTER);

            WebElement url = driver.findElement(By.cssSelector(".iUh30.tjvcx"));
            String expectedUrl = url.getText();
            System.out.println(expectedUrl);

            WebElement link = driver.findElement(By.cssSelector("div.r>a>h3"));
            link.click();

            if (expectedUrl.equals(driver.getCurrentUrl())) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
                System.out.println("Expected = " + expectedUrl);
                System.out.println("Actual = " + driver.getCurrentUrl());
            }

            driver.navigate().back();

        }
        driver.quit();

    }


}
