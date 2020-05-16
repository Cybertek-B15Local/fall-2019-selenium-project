package com.cybertek.tests.day21_db_testing;

import com.cybertek.base.VytrackPageBase;
import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.DBUtils;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class CreateNewContactDBTest extends VytrackTestBase {

    @BeforeMethod
    public void setUp(){
        // create db connection

    }

    @Test
    public void createContactTests(){
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"),
                ConfigurationReader.getProperty("sales_manager_password"));
        driver.get("https://qa3.vytrack.com/contact/create");
        // generate test data for creating new user
        Faker faker = new Faker();
        String eFirstName = faker.name().firstName();
        String eLastName = faker.name().lastName();
        String company = faker.company().url().substring(4);
        String eEmail = eFirstName.toLowerCase()+eLastName.toLowerCase()+"@"+company;
        System.out.println("eEmail = " + eEmail);
        BrowserUtils.wait(3);
        // create new user with the given test data
        createContactsPage.firstName.sendKeys(eFirstName);
        createContactsPage.lastName.sendKeys(eLastName);
        createContactsPage.email.sendKeys(eEmail);
        createContactsPage.saveAndClose.click();
        BrowserUtils.wait(3);

        // get the new user information: first name, last name, email from database based on email
        // first name, last name  --. in the contact
        // email --. email
        // we have to use inner join to join the contact table and email table based on the id of the contact
        // use email in where of query to filter the results

        String sql = "select  orocrm_contact.first_name, orocrm_contact.last_name, orocrm_contact_email.email \n" +
                "from orocrm_contact\n" +
                "join orocrm_contact_email\n" +
                "on orocrm_contact.id =orocrm_contact_email.owner_id\n" +
                "where orocrm_contact_email.email = 'picard@starfleet.com';\n";


        Map<String, Object> dbData = DBUtils.getRowMap(sql);
        System.out.println(dbData);

    }

}
