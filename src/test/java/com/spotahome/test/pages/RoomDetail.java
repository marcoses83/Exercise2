package com.spotahome.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomDetail extends BasePage {
    @FindBy(xpath = "//div[@class='room--minmaxstay']/div[@class='apartment-info-item'][0]")
    private WebElement minStay;

    @FindBy(xpath = "//div[@class='room--minmaxstay']/div[@class='apartment-info-item'][1]")
    private WebElement maxStay;

    @FindBy(className = "room--availability")
    private WebElement availabilityDate;

    @FindBy(className = "datepicker-message datepicker-message--valid-dates")
    private WebElement validDatesMessage;

    @FindBy(xpath = "//span[@class='datepicker-message__description']//span/i[0]")
    private WebElement validFromDate;

    @FindBy(xpath = "//span[@class='datepicker-message__description']//span/i[1]")
    private WebElement validToDate;

    public boolean areSelectedDatesValid() {
        String selectedFromDateString = getBrowser().getCurrentUrl().split("\\?")[1].split("&")[0].split("=")[1];
        LocalDate selectedFromDate = LocalDate.parse(selectedFromDateString);
        String selectedToDateString = getBrowser().getCurrentUrl().split("\\?")[1].split("&")[1].split("=")[1];
        LocalDate selectedToDate = LocalDate.parse(selectedToDateString);

        if (validDatesMessage.isDisplayed()) {
            LocalDate fromDate = LocalDate.parse(validFromDate.getText());
            LocalDate toDate = LocalDate.parse(validToDate.getText());

            if (selectedFromDate.compareTo(fromDate) < 0 || selectedFromDate.compareTo(toDate) > 0) {
                return false;
            }
        }

        int minStayDays = 0;
        Pattern pattern = Pattern.compile("\\((\\d+)[^\\d]*\\)");
        Matcher matcher = pattern.matcher(minStay.getText());
        if (matcher.find())
        {
            minStayDays = Integer.parseInt(matcher.group(1));
        }

        if (selectedFromDate.plusDays(minStayDays -1).compareTo(selectedToDate) < 0) {
            return false;
        }

        int maxStayDays = 0;
        matcher = pattern.matcher(maxStay.getText());
        if (matcher.find())
        {
            maxStayDays = Integer.parseInt(matcher.group(1));
        }

        if (selectedFromDate.plusDays(maxStayDays -1).compareTo(selectedToDate) > 0) {
            return false;
        }

        LocalDate availableDate = LocalDate.now();
        pattern = Pattern.compile("[^Available: ].*");
        matcher = pattern.matcher(availabilityDate.getText());
        if (matcher.find()) {
            availableDate = LocalDate.parse(matcher.group(1));
        }

        if(selectedFromDate.compareTo(availableDate) < 0) {
            return false;
        }

        return true;
    }

    public void selectValidDates() {

    }
}
