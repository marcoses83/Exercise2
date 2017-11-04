package com.spotahome.test.enums;

public enum City {
    BARCELONA("barcelona"), BERLIN("berlin"), BILBAO("bilbao"), BOLOGNA("bologna"), BRUSSELS("brussels"), DUBAI("dubai"),
    DUBLIN("dublin"), FLORENCE("florence"), GRANADA("granada"), LONDON("london"), LYON("lyon"), MADRID("madrid"),
    MILAN("milan"), PARIS("paris"), ROME("rome"), SEVILLE("seville"), VALENCIA("valencia"), VIENNA("vienna");

    private String value;

    City(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
