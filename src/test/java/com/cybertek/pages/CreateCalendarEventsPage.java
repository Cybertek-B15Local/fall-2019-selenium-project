package com.cybertek.pages;

import com.cybertek.base.VytrackPageBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCalendarEventsPage extends VytrackPageBase {
    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "oro_calendar_event_form[allDay]")
    public WebElement allDayEventCheckbox;

    @FindBy(css = "input[id^='recurrence-repeat-view']")
    public WebElement repeatCheckbox;

}
