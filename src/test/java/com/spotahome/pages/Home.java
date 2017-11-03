package com.spotahome.pages;

import com.spotahome.enums.City;
import com.spotahome.enums.Month;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Home {
    @FindBy(className = "city-selector--city")
    private WebElement citySelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-select pika-select-month']")
    private WebElement monthFromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-select pika-select-year']")
    private WebElement yearFromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-table']/tbody//button")
    private WebElement dayFromCells;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container TO']//select[@class='pika-select pika-select-month']")
    private WebElement monthToSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container TO']//select[@class='pika-select pika-select-year']")
    private WebElement yearToSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-table']/tbody//button")
    private WebElement dayToCells;

    @FindBy(className = "city-selector--cta")
    private WebElement exploreButton;

    public void selectCity(City city) {
        Select selectObject = new Select(citySelector);
        selectObject.selectByValue(String.valueOf(city));
    }

    public void selectFromMonth(Month month) {
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
