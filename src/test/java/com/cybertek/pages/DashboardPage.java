package com.cybertek.pages;

import com.cybertek.base.VytrackPageBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends VytrackPageBase {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
