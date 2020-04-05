package com.cybertek.base;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class VytrackPageBase {

    public VytrackPageBase() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "oro-subtitle")
    public WebElement pageHeader;

    @FindBy(xpath = "//span[contains(text(), 'Fleet')][@class='title title-level-1']")
    public WebElement fleet;

    @FindBy(xpath = "//span[.='Vehicles'][@class='title title-level-2']")
    public WebElement vehicles;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement accountHolderName;

    @FindBy(css = ".title-level-1")
    public List<WebElement> menu1Options;

    public void changeMenu(String menu1, String menu2) {
        String menu1X = "//span[contains(text(), '"+menu1+"')][@class='title title-level-1']";
        WebElement menu1El = Driver.getDriver().findElement(By.xpath(menu1X));

        String menu2X = "//span[.='"+menu2+"'][@class='title title-level-2']";
        WebElement menu2El = Driver.getDriver().findElement(By.xpath(menu2X));

        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), 5);

        wait.until(ExpectedConditions.elementToBeClickable(menu1El));

        menu1El.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(menu2El));
        menu2El.click();

    }

}
