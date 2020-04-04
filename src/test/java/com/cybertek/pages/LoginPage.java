package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        // page object classes needs contructor. here we have to call the PageFactory.initElements
        // from selenium and pass a webdriver object and this class as param
        PageFactory.initElements(Driver.getDriver(), this);


    }
}
