package com.spotahome.test.pages;

import com.spotahome.test.enums.City;
import com.spotahome.test.framework.DatePicker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Home extends BasePage {
    @FindBy(className = "city-selector--city")
    private WebElement citySelector;

    @FindBy(className = "city-selector--date")
    private WebElement dateSelector;

    @FindBy(className = "city-selector--cta")
    private WebElement exploreButton;

    public void selectCity(City city) {
        Select selectObject = new Select(citySelector);
        selectObject.selectByValue(city.getValue());
    }

    public void selectDateFrom(int year, int month, int day) {
        new DatePicker(dateSelector).selectDateFrom(year, month, day);
    }

    public void selectDateTo(int year, int month, int day) {
        new DatePicker(dateSelector).selectDateTo(year, month, day);
    }

    public void explore() {
        exploreButton.click();
    }
}
