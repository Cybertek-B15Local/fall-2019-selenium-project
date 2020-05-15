package com.cybertek.pages;

import com.cybertek.base.VytrackPageBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage extends VytrackPageBase {
    public CreateContactsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "oro_contact_form[firstName]")
    public WebElement firstName;

    @FindBy(name = "oro_contact_form[lastName]")
    public WebElement lastName;

    @FindBy(name = "oro_contact_form[emails][0][email]")
    public WebElement email;

    @FindBy(css = "button[type='submit']")
    public WebElement saveAndClose;

}
