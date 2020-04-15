package com.vytrack.pages;

import com.vytrack.base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCalendarEventsPage extends PageBase {

    @FindBy(name = "oro_calendar_event_form[allDay]")
    public WebElement allDayEventCheckbox;

    @FindBy(css = "input[id^='recurrence-repeat-view']")
    public WebElement repeatCheckbox;

}
