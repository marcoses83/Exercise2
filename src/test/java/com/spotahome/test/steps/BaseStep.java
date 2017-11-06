package com.spotahome.test.steps;

import com.spotahome.test.framework.Browser;
import com.spotahome.test.pages.Home;
import com.spotahome.test.pages.RoomDetail;
import com.spotahome.test.pages.Rooms;
import com.spotahome.test.steps.world.StepsWorld;

class BaseStep {
    private StepsWorld world;

    BaseStep(StepsWorld world) {
        this.world = world;
    }

    Browser getBrowser() {
        return world.getBrowser();
    }

    void setBrowser(Browser browser) {
        world.setBrowser(browser);
    }

    Object getContextValue(String key) { return world.getValue(key); }

    void addContextValue(String key, Object value) { world.addValue(key, value); }

    Home getHome() {
        return world.getBrowser().getPage(Home.class);
    }

    Rooms getRooms() {
        return world.getBrowser().getPage(Rooms.class);
    }

    RoomDetail getRoomDetail() {
        return world.getBrowser().getPage(RoomDetail.class);
    }
}
