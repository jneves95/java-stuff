package com.company.builder.components;

public class GPSNavigator {
    private String route;

    public GPSNavigator() {
        this.route = "No destination set.";
    }

    public GPSNavigator(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
