package com.cybertek.tests.day7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTests {
    // main method to invoke the tests
    public static void main(String[] args) throws InterruptedException {
        nameMatchTest();

    }

    // each test will be a separate method

    /**
     * open browser
     * go to amazon
     * search for any item
     * remember the name of the first result
     * click on the first result
     * verify that product name is same in the product page
     */
    private static void nameMatchTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        String searchTerm = "disinfectant wipes";
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        // OPTION 1: enter search term and hit ENTER button
//        searchInput.sendKeys(searchTerm + Keys.ENTER);
        // OPTION 2: Enter search term and click the search button
        searchInput.sendKeys(searchTerm);
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();

        Thread.sleep(2000);

        WebElement firstResult = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        System.out.println(firstResult.getText());
        String expectedName = firstResult.getText();

        firstResult.click();

        WebElement productName = driver.findElement(By.id("productTitle"));
        String actualName = productName.getText();

        System.out.println(actualName);

        if (expectedName.equals(actualName)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedName = " + expectedName);
            System.out.println("actualName = " + actualName);
        }
        driver.quit();
    }


}
