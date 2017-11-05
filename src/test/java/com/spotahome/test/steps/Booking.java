package com.spotahome.test.steps;

import com.spotahome.test.enums.City;
import com.spotahome.test.steps.world.StepsWorld;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

public class Booking extends BaseStep {
    public Booking(StepsWorld world) {
        super(world);
    }

    /*@BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }*/

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
        LocalDate fromDate = randomDate(LocalDate.now());
        LocalDate toDate = randomDate(fromDate);

        getHome().selectFromDate(fromDate.getYear(), fromDate.getMonth(), fromDate.getDayOfMonth());
        getHome().selectToDate(toDate.getYear(), toDate.getMonth(), toDate.getDayOfMonth());
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
        if (!getRoomDetail().areSelectedDatesValid()) {
            getRoomDetail().selectValidDates();
        }
    }

    private LocalDate randomDate(LocalDate start) {
        final int MAX_DATE_RANGE_IN_DAYS = 365 * 10;
        final int MIN_DATE_RANGE_IN_DAYS = 30;
        int daysToAdd = new Random().ints(MIN_DATE_RANGE_IN_DAYS, MAX_DATE_RANGE_IN_DAYS).findFirst().getAsInt();
        return start.plusDays(daysToAdd);
    }
}
