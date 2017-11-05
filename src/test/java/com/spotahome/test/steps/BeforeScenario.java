package com.spotahome.test.steps;

import com.spotahome.test.helper.Browser;
import com.spotahome.test.steps.world.StepsWorld;
import cucumber.api.java.Before;

public class BeforeScenario extends BaseStep {
    public BeforeScenario(StepsWorld world) {
        super(world);
    }

    @Before(order = 0)
    public void setup() {
        setBrowser(new Browser());
    }
}
