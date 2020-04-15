package com.vytrack.utilities;

import com.vytrack.pages.CreateCalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesPage;

public class Pages {

    public LoginPage getLoginPage() {
        return new LoginPage();
    }

    public VehiclesPage getVehiclesPage() {
        return new VehiclesPage();
    }

    public DashboardPage getDashboardPage() {
        return new DashboardPage();
    }

    public CreateCalendarEventsPage getCreateCalendarEventsPage() {
        return new CreateCalendarEventsPage();
    }
}
