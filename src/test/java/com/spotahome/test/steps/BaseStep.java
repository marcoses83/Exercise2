package com.spotahome.test.steps;

import com.spotahome.test.framework.Browser;
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
        return this.world.getBrowser();
    }

    public void setBrowser(Browser browser) {
        this.world.setBrowser(browser);
    }

    public Object getContextValue(String key) { return this.world.getValue(key); }

    public void addContextValue(String key, Object value) { this.world.addValue(key, value); }

    public Home getHome() {
        return this.world.getBrowser().getPage(Home.class);
    }

    public Rooms getRooms() {
        return this.world.getBrowser().getPage(Rooms.class);
    }

    public RoomDetail getRoomDetail() {
        return this.world.getBrowser().getPage(RoomDetail.class);
    }
}
