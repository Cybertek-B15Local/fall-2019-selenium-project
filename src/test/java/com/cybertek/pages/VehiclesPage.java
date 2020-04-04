package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesPage {

    public VehiclesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "oro-subtitle")
    public WebElement pageHader;

}
