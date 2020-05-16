package com.cybertek.tests.day21_db_testing;

import com.cybertek.base.VytrackPageBase;
import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class CreateNewContactDBTest extends VytrackTestBase {

    @Test
    public void createContactTests(){
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"),
                ConfigurationReader.getProperty("sales_manager_password"));
        driver.get("https://qa3.vytrack.com/contact/create");
        Faker faker = new Faker();
        String eFirstName = faker.name().firstName();
        String eLastName = faker.name().lastName();
        String eEmail = faker.internet().safeEmailAddress(eFirstName.toLowerCase()+eLastName.toLowerCase());
        System.out.println("eEmail = " + eEmail);
        BrowserUtils.wait(3);
        createContactsPage.firstName.sendKeys(eFirstName);
        createContactsPage.lastName.sendKeys(eLastName);
        createContactsPage.email.sendKeys(eEmail);
        createContactsPage.saveAndClose.click();
        BrowserUtils.wait(3);

    }

}
