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
        Pattern pattern;

        switch (pageName) {
            case "Rooms":
                pattern = Pattern.compile("");
            case "Booking":
                pattern = Pattern.compile("https://staging.spotahome.com/booking");
                break;
            default:
                pattern = Pattern.compile("");
                break;
        }

        Assert.assertTrue(pattern.matcher(getBrowser().getCurrentUrl()).find());
    }
}
