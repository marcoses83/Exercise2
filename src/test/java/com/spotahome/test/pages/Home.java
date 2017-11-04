package com.spotahome.test.pages;

import com.spotahome.test.enums.City;
import com.spotahome.test.enums.Month;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Home extends BasePage {
    @FindBy(className = "city-selector--city")
    private WebElement citySelector;

    @FindBy(className = "city-selector--date__from")
    private WebElement fromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-select pika-select-month']")
    private WebElement monthFromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-select pika-select-year']")
    private WebElement yearFromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-table']/tbody//button")
    private WebElement dayFromCells;

    @FindBy(className = "city-selector--date__to")
    private WebElement toSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container TO']//select[@class='pika-select pika-select-month']")
    private WebElement monthToSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container TO']//select[@class='pika-select pika-select-year']")
    private WebElement yearToSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-table']/tbody//button")
    private WebElement dayToCells;

    @FindBy(className = "city-selector--cta")
    //@FindBy(xpath = "//a[contains(@class, 'city-selector--cta')]")
    private WebElement exploreButton;

    public void selectCity(City city) {
        Select selectObject = new Select(citySelector);
        selectObject.selectByValue(city.getValue());
    }

    public void selectFromDate(int year, Month month, int day) {
        selectFromMonth(month);
        selectFromYear(year);
        selectFromDay(day);
    }

    public void selectToDate(int year, Month month, int day) {
        selectToMonth(month);
        selectToYear(year);
        selectToDay(day);
    }

    public void selectFromMonth(Month month) {
        fromSelector.click();

        Select selectObject = new Select(monthFromSelector);
        selectObject.selectByValue(String.valueOf(month.ordinal()));
    }

    public void selectFromYear(int year) {
        Select selectObject = new Select(yearFromSelector);
        selectObject.selectByValue(String.valueOf(year));
    }

    public void selectFromDay(int day) {
        dayFromCells.findElement(By.cssSelector("[data-pika-day='" + day + "']")).click();
    }

    public void selectToMonth(Month month) {
        toSelector.click();

        Select selectObject = new Select(monthToSelector);
        selectObject.selectByValue(String.valueOf(month.ordinal()));
    }

    public void selectToYear(int year) {
        Select selectObject = new Select(yearToSelector);
        selectObject.selectByValue(String.valueOf(year));
    }

    public void selectToDay(int day) {
        dayToCells.findElement(By.cssSelector("[data-pika-day='" + day + "']")).click();
    }

    public void explore() {
        exploreButton.click();
    }
}

class DateSelector {

}
