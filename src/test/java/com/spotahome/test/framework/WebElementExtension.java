package com.spotahome.test.framework;

import org.openqa.selenium.WebElement;

public class WebElementExtension {
    public static boolean isDisplayed(WebElement elem) {
        boolean isDisplayed;
        try {
            isDisplayed = elem.isDisplayed();
        } catch (Exception ex) {
            isDisplayed = false;
        }

        return isDisplayed;
    }
}
