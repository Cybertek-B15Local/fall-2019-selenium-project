package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "oro-subtitle")
    public WebElement pageHader;

    @FindBy(xpath = "//span[contains(text(), 'Fleet')][@class='title title-level-1']")
    public WebElement fleet;

    @FindBy(xpath = "//span[.='Vehicles'][@class='title title-level-2']")
    public WebElement vehicles;
}
