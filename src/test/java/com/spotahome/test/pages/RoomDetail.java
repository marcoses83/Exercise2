package com.spotahome.test.pages;

import com.spotahome.test.framework.DatePicker;
import com.spotahome.test.framework.DateRandomizer;
import com.spotahome.test.framework.WebElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomDetail extends BasePage {
    @FindBy(xpath = "//div[@class='room--minmaxstay']/div[@class='apartment-info--item'][1]")
    private WebElement minStay;

    @FindBy(xpath = "//div[@class='room--minmaxstay']/div[@class='apartment-info--item'][2]")
    private WebElement maxStay;

    @FindBy(xpath = "//span[@class='datepicker-message__description']//i[1]")
    private WebElement validDateFrom;

    @FindBy(xpath = "//span[@class='datepicker-message__description']//i[2]")
    private WebElement validDateTo;

    @FindBy(css = "div.booknow-card--body-dates")
    private WebElement dateSelector;

    @FindBy(css = "a.button--book-now")
    private WebElement bookNowButton;

    public void selectValidDates() {
        try {
            LocalDate dateFromToSelect = getValidDateFrom();
            LocalDate dateToToSelect = getValidDateTo(dateFromToSelect);

            new DatePicker(dateSelector).selectDateFrom(dateFromToSelect.getYear(), dateFromToSelect.getMonth().getValue(), dateFromToSelect.getDayOfMonth());
            new DatePicker(dateSelector).selectDateTo(dateToToSelect.getYear(), dateToToSelect.getMonth().getValue(), dateToToSelect.getDayOfMonth());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean areSelectedDatesValid() {
        return WebElementExtension.isDisplayed(bookNowButton);
    }

    public void book() {
        ((JavascriptExecutor)getBrowser().getDriver()).executeScript("arguments[0].scrollIntoView(true);", dateSelector);
        new WebDriverWait(getBrowser().getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.booknow--spinner-loader")));
        bookNowButton.click();
    }

    private LocalDate getValidDateFrom() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM dd, yyyy", Locale.ENGLISH);

        Date parsedDateFrom = sdf.parse(validDateFrom.getText());
        LocalDate dateFrom = parsedDateFrom.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Date parsedDateTo = sdf.parse(validDateTo.getText());
        LocalDate dateTo = parsedDateTo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return DateRandomizer.randomDate(dateFrom, dateTo);
    }

    private LocalDate getValidDateTo(LocalDate minDate) {
        int minStayDays = 0;
        int maxStayDays = 0;
        Pattern pattern = Pattern.compile("\\((\\d+)[^\\d]*\\)");
        Matcher minStayDaysMatcher = pattern.matcher(minStay.getText());
        Matcher maxStayDaysMatcher = pattern.matcher(maxStay.getText());

        if (minStayDaysMatcher.find()) {
            minStayDays = Integer.parseInt(minStayDaysMatcher.group(1));
        }

        if (maxStayDaysMatcher.find()) {
            maxStayDays = Integer.parseInt(maxStayDaysMatcher.group(1));
        }

        return DateRandomizer.randomDate(minDate, minStayDays, maxStayDays);
    }
}
