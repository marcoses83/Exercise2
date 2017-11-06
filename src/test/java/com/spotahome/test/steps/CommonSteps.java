package com.spotahome.test.steps;

import com.spotahome.test.steps.world.StepsWorld;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CommonSteps extends BaseStep {
    public CommonSteps(StepsWorld world) {
        super(world);
    }

    @Then("^I should be at \"([^\"]*)\" page$")
    public void iShouldBeAtPage(String pageName) throws Throwable {
        String stringToMatch = "";

        switch (pageName) {
            case "Booking":
                stringToMatch = "https://staging.spotahome.com/booking";
                break;
            default:
                break;
        }

        Assert.assertTrue(getBrowser().getCurrentUrl().contains(stringToMatch));
    }
}
