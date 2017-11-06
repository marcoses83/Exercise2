package com.spotahome.test.steps.world;

import com.spotahome.test.framework.Browser;

import java.util.HashMap;

public class StepsWorld {

    private Browser browser;
    private HashMap<String, Object> contextValues = new HashMap<>();

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public void addValue (String key, Object value) {
        this.contextValues.put(key, value);
    }

    public Object getValue (String key) {
        return this.contextValues.get(key);
    }
}
