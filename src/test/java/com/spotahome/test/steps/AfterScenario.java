package com.spotahome.test.steps;

import com.spotahome.test.steps.world.StepsWorld;
import cucumber.api.java.After;

public class AfterScenario extends BaseStep {
    public AfterScenario(StepsWorld world) {
        super(world);
    }

    @After
    public void tearDown() {
        getBrowser().close();
    }
}
