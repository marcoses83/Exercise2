package com.spotahome.test.steps;

import com.spotahome.test.enums.City;
import com.spotahome.test.framework.DateRandomizer;
import com.spotahome.test.steps.world.StepsWorld;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.time.LocalDate;
import java.util.Random;

public class Booking extends BaseStep {
    public Booking(StepsWorld world) {
        super(world);
    }

    @Given("^I am in home page$")
    public void iAmInHomePage() throws Throwable {
        getHome().getBrowser().navigateTo("http://staging.spotahome.com");
    }

    @When("^I select a city and date$")
    public void iSelectACityAndDate() throws Throwable {
        iSelectACity();
        iSelectADate();
        iClickExploreButton();
    }

    @When("^I select a city$")
    public void iSelectACity() throws Throwable {
        City city = City.values()[new Random().nextInt(City.values().length)];
        getHome().selectCity(city);
    }

    @When("^I select a date$")
    public void iSelectADate() throws Throwable {
        LocalDate fromDate = DateRandomizer.randomDate(LocalDate.now());
        LocalDate toDate = DateRandomizer.randomDate(fromDate);

        getHome().selectDateFrom(fromDate.getYear(), fromDate.getMonth().getValue(), fromDate.getDayOfMonth());
        getHome().selectDateTo(toDate.getYear(), toDate.getMonth().getValue(), toDate.getDayOfMonth());
    }

    @When("^I click Explore button$")
    public void iClickExploreButton() throws Throwable {
        getHome().explore();
    }

    @When("^I select a room$")
    public void iSelectARoom() throws Throwable {
        getRooms().selectRoom();
    }

    @When("^I select a date and book$")
    public void iSelectADateAndBook() throws Throwable {
        getBrowser().switchTab(1);

        if (!getRoomDetail().areSelectedDatesValid()) {
            getRoomDetail().selectValidDates();
        }

        getRoomDetail().book();
    }
}
