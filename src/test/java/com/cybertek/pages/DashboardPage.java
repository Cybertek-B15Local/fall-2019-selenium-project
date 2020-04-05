package com.cybertek.pages;

import com.cybertek.base.VytrackBasePage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends VytrackBasePage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
