package com.spotahome.test.pages;

import com.spotahome.test.enums.City;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Month;

public class Home extends BasePage {
    @FindBy(className = "city-selector--city")
    private WebElement citySelector;

    @FindBy(className = "city-selector--date__from")
    private WebElement dateFromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-select pika-select-month']")
    private WebElement monthFromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-select pika-select-year']")
    private WebElement yearFromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//table[@class='pika-table']/tbody")
    private WebElement dayFromCells;

    @FindBy(className = "city-selector--date__to")
    private WebElement dateToSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container TO']//select[@class='pika-select pika-select-month']")
    private WebElement monthToSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container TO']//select[@class='pika-select pika-select-year']")
    private WebElement yearToSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//table[@class='pika-table']/tbody")
    private WebElement dayToCells;

    @FindBy(className = "city-selector--cta")
    //@FindBy(xpath = "//a[contains(@class, 'city-selector--cta')]")
    private WebElement exploreButton;

    public void selectCity(City city) {
        Select selectObject = new Select(citySelector);
        selectObject.selectByValue(city.getValue());
    }

    public void selectFromDate(int year, Month month, int day) {
        expandDateFromSelector();
        selectFromYear(year);
        selectFromMonth(month);
        selectFromDay(day);
    }

    public void selectToDate(int year, Month month, int day) {
        expandDateToSelector();
        selectToYear(year);
        selectToMonth(month);
        selectToDay(day);
    }

    public void expandDateFromSelector() {
        dateFromSelector.click();
    }


    public void selectFromYear(int year) {
        Select selectObject = new Select(yearFromSelector);
        selectObject.selectByValue(String.valueOf(year));
    }

    public void selectFromMonth(Month month) {
        Select selectObject = new Select(monthFromSelector);
        selectObject.selectByValue(String.valueOf(month.ordinal() - 1));
    }

    public void selectFromDay(int day) {
        expandDateFromSelector();

        try {
            dayFromCells.findElement(By.cssSelector("[data-pika-day='" + day + "']")).click();
        }
        catch (Exception ex) {
            System.out.println("Day: " + day);
        }
    }

    public void expandDateToSelector() {
        dateToSelector.click();
    }

    public void selectToYear(int year) {
        Select selectObject = new Select(yearToSelector);
        selectObject.selectByValue(String.valueOf(year));
    }

    public void selectToMonth(Month month) {
        dateToSelector.click();

        Select selectObject = new Select(monthToSelector);
        selectObject.selectByValue(String.valueOf(month.ordinal()));
    }

    public void selectToDay(int day) {
        expandDateFromSelector();

        dayToCells.findElement(By.cssSelector("[data-pika-day='" + day + "']")).click();
    }

    public void explore() {
        exploreButton.click();
    }
}

class DateSelector {

}
