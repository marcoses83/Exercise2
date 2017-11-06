package com.spotahome.test.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {
    private WebElement dateSelector;

    public DatePicker(WebElement dateSelector) {
        this.dateSelector = dateSelector;
    }

    public void selectDateFrom(int year, int month, int day) {
        selectYearFrom(year);
        selectMonthFrom(month);
        selectDayFrom(day);
    }

    public void selectDateTo(int year, int month, int day) {
        selectYearTo(year);
        selectMonthTo(month);
        selectDayTo(day);
    }

    private void expandDateFromSelector() {
        WebElement dateFromSelector = dateSelector.findElement(By.xpath("input[1]"));
        dateFromSelector.click();
    }

    private void selectYearFrom(int year) {
        expandDateFromSelector();
        WebElement yearFromSelector = dateSelector.findElement(By.xpath("div[1]//select[@class='pika-select pika-select-year']"));
        Select selectObject = new Select(yearFromSelector);
        selectObject.selectByValue(String.valueOf(year));
    }

    private void selectMonthFrom(int month) {
        expandDateFromSelector();
        WebElement monthFromSelector = dateSelector.findElement(By.xpath("div[1]//select[@class='pika-select pika-select-month']"));
        Select selectObject = new Select(monthFromSelector);
        selectObject.selectByValue(String.valueOf(month - 1));
    }

    private void selectDayFrom(int day) {
        expandDateFromSelector();
        WebElement dayFromCells = dateSelector.findElement(By.xpath("div[1]//table[@class='pika-table']/tbody"));
        dayFromCells.findElement(By.cssSelector("[data-pika-day='" + day + "']")).click();
    }

    private void expandDateToSelector() {
        WebElement dateToSelector = dateSelector.findElement(By.xpath("input[2]"));
        dateToSelector.click();
    }

    private void selectYearTo(int year) {
        expandDateToSelector();
        WebElement yearToSelector = dateSelector.findElement(By.xpath("div[2]//select[@class='pika-select pika-select-year']"));
        Select selectObject = new Select(yearToSelector);
        selectObject.selectByValue(String.valueOf(year));
    }

    private void selectMonthTo(int month) {
        expandDateToSelector();
        WebElement monthToSelector = dateSelector.findElement(By.xpath("div[2]//select[@class='pika-select pika-select-month']"));
        Select selectObject = new Select(monthToSelector);
        selectObject.selectByValue(String.valueOf(month -1));
    }

    private void selectDayTo(int day) {
        expandDateToSelector();
        WebElement dayToCells = dateSelector.findElement(By.xpath("div[2]//table[@class='pika-table']/tbody"));

        dayToCells.findElement(By.cssSelector("[data-pika-day='" + day + "']")).click();
    }
}
