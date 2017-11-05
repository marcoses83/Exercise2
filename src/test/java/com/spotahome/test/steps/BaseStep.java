package com.spotahome.test.steps;

import com.spotahome.test.helper.Browser;
import com.spotahome.test.pages.Home;
import com.spotahome.test.pages.RoomDetail;
import com.spotahome.test.pages.Rooms;
import com.spotahome.test.steps.world.StepsWorld;

public class BaseStep {
    private StepsWorld world;

    public BaseStep(StepsWorld world) {
        this.world = world;
    }

    public Browser getBrowser() {
        return world.getBrowser();
    }

    public void setBrowser(Browser browser) {
        world.setBrowser(browser);
    }

    public Home getHome() {
        return world.getBrowser().getPage(Home.class);
    }

    public Rooms getRooms() {
        return world.getBrowser().getPage(Rooms.class);
    }

    public RoomDetail getRoomDetail() {
        return world.getBrowser().getPage(RoomDetail.class);
    }
}
