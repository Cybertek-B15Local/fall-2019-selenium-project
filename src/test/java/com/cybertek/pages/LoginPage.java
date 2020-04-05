package com.cybertek.pages;

import com.cybertek.base.VytrackPageBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        // page object classes needs contructor. here we have to call the PageFactory.initElements
        // from selenium and pass a webdriver object and this class as param
        PageFactory.initElements(Driver.getDriver(), this);

    }

    // FindBy --> we provide the locator for webelement
    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement logIn;

    @FindBy(css = ".alert-error>div")
    public WebElement errorMessage;

   public void login(String username, String password){
       this.username.sendKeys(username);
       this.password.sendKeys(password);
       logIn.click();
   }

}
