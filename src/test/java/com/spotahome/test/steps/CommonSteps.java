package com.spotahome.test.steps;

import com.spotahome.test.steps.world.StepsWorld;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.regex.Pattern;

public class CommonSteps extends BaseStep {
    public CommonSteps(StepsWorld world) {
        super(world);
    }

    @Then("^I should be at \"([^\"]*)\" page$")
    public void iShouldBeAtPage(String pageName) throws Throwable {
        String stringToMatch = "";
        StringBuilder sb = new StringBuilder("https://staging.spotahome.com/");

        switch (pageName) {
            case "Rooms":
                sb.append(getContextValue("selectedCity")).append("?").append("move-in=");
                stringToMatch = sb.toString();
                break;
            case "Booking":
                sb.append("booking/").append(getContextValue("selectedCity"));
                stringToMatch = sb.toString();
                break;
            default:
                break;
        }

        Assert.assertTrue(getBrowser().getCurrentUrl().contains(stringToMatch));
    }
}
