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

    @When("^I select city \"([^\"]*)\" and date from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iSelectCityAndDateFromTo(String city, String dateFrom, String dateTo) throws Throwable {
        selectCity(city);
        selectDate(dateFrom, dateTo);
        clickExploreButton();
    }

    @When("^I select a random city and date$")
    public void iSelectARandomCityAndDate() throws Throwable {
        selectRandomCity();
        selectRandomDate();
        clickExploreButton();
    }

    @When("^I select a random room$")
    public void iSelectARandomRoom() throws Throwable {
        getRooms().selectRoom();
    }

    @When("^I select a random date and book$")
    public void iSelectARandomDateAndBook() throws Throwable {
        getBrowser().switchTab(1);

        if (!getRoomDetail().areSelectedDatesValid()) {
            getRoomDetail().selectValidDates();
        }

        getRoomDetail().book();
    }

    private void selectCity(String cityString) {
        City city = City.valueOf(cityString.toUpperCase());
        getHome().selectCity(city);
        addContextValue("selectedCity", city.getValue());
    }

    private void selectRandomCity() throws Throwable {
        City city = City.values()[new Random().nextInt(City.values().length)];
        getHome().selectCity(city);
        addContextValue("selectedCity", city.getValue());
    }

    private void selectDate(String dateFromString, String dateToString) {
        LocalDate dateFrom = LocalDate.parse(dateFromString);
        LocalDate dateTo = LocalDate.parse(dateToString);

        getHome().selectDateFrom(dateFrom.getYear(), dateFrom.getMonth().getValue(), dateFrom.getDayOfMonth());
        getHome().selectDateTo(dateTo.getYear(), dateTo.getMonth().getValue(), dateTo.getDayOfMonth());
    }

    private void selectRandomDate() throws Throwable {
        LocalDate dateFrom = DateRandomizer.randomDate(LocalDate.now());
        LocalDate dateTo = DateRandomizer.randomDate(dateFrom);

        getHome().selectDateFrom(dateFrom.getYear(), dateFrom.getMonth().getValue(), dateFrom.getDayOfMonth());
        getHome().selectDateTo(dateTo.getYear(), dateTo.getMonth().getValue(), dateTo.getDayOfMonth());
    }

    private void clickExploreButton() throws Throwable {
        getHome().explore();
    }
}
