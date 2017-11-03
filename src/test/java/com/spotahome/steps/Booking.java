package com.spotahome.steps;

import com.spotahome.enums.City;
import com.spotahome.enums.Month;
import com.spotahome.pages.Home;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Booking {
    protected static WebDriver driver;
    protected Home home;

    public Booking() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdrivers/chromedriver.exe");

        driver = new ChromeDriver();
        home = new Home();
    }

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @When("^I select a city$")
    public void iSelectACity() throws Throwable {
        City city = City.values()[new Random().nextInt(City.values().length)];
        home.selectCity(city);
    }

    @Given("^I am in home page$")
    public void iAmInHomePage() throws Throwable {
        driver.navigate().to("http://staging.spotahome.com");
    }

    @And("^I select a date$")
    public void iSelectADate() throws Throwable {
        home.selectFromMonth(randomMonthBetween());
        home.selectFromYear(randomYearBetween());
        home.selectFromDay(randomDayBetween());

        home.selectToMonth(randomMonthBetween());
        home.selectToYear(randomYearBetween());
        home.selectToDay(randomDayBetween());
    }

    @And("^I click Explore button$")
    public void iClickExploreButton() throws Throwable {
        home.explore();
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
