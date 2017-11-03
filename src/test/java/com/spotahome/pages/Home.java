package com.spotahome.pages;

import com.spotahome.enums.Month;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
    @FindBy(className = "city-selector--city")
    private WebElement citySelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-select pika-select-month']")
    private WebElement monthFromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container FROM']//select[@class='pika-select pika-select-year']")
    private WebElement yearFromSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container TO']//select[@class='pika-select pika-select-month']")
    private WebElement monthToSelector;

    @FindBy(xpath = "//div[@class='city-selector__pikaday-container TO']//select[@class='pika-select pika-select-year']")
    private WebElement yearToSelector;


    public void selectFromMonth(Month month) {
        monthFromSelector.sendKeys(month.name());
    }

    public void selectFromYear(String year) {
        yearFromSelector.sendKeys(year);
    }

    public void selectToMonth(Month month) {
        monthToSelector.sendKeys(month.name());
    }

    public void selectToYear(String year) {
        yearToSelector.sendKeys(year);
    }
}

class DateSelector {

}
