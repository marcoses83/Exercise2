package com.spotahome.test.steps;

import com.spotahome.test.enums.City;
import com.spotahome.test.enums.Month;
import com.spotahome.test.steps.world.StepsWorld;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.Calendar;
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

    @When("^I select a city$")
    public void iSelectACity() throws Throwable {
        City city = City.values()[new Random().nextInt(City.values().length)];
        getHome().selectCity(city);
    }

    @Given("^I am in home page$")
    public void iAmInHomePage() throws Throwable {
        getHome().getBrowser().navigateTo("http://staging.spotahome.com");
    }

    @And("^I select a date$")
    public void iSelectADate() throws Throwable {
        getHome().selectFromDate(randomYearBetween(), randomMonthBetween(), randomDayBetween());
        getHome().selectToDate(randomYearBetween(), randomMonthBetween(), randomDayBetween());
    }

    @And("^I click Explore button$")
    public void iClickExploreButton() throws Throwable {
        getHome().explore();
    }

    private Month randomMonthBetween() {
        return Month.values()[new Random().nextInt(Month.values().length)];
    }

    private int randomYearBetween() {
        int start = Calendar.getInstance().get(Calendar.YEAR);
        int end = start + 10;
        return start + (int)Math.round(Math.random() * (end - start));
    }

    private int randomDayBetween() {
        int start = 1;
        int end = 28;
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
