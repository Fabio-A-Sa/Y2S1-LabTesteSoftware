package com.g801.supaplex.Model.Level

import spock.lang.Specification

class ScreenSettingsTest extends Specification {

    private ScreenSettings screenSettings;

    def setup() {
        screenSettings = new ScreenSettings();
    }

    def "Initialization"() {

        expect:
            screenSettings.getWidth() == 7;
            screenSettings.getHeight() == 9;
            screenSettings.getMapBounds() != null;
            screenSettings.getXmin() == 0;
            screenSettings.getYmin() == 0;
    }

    def "Screen Map Bounds"() {

        when:
            screenSettings.setMapBounds(120, 240);
        then:
            screenSettings.getMapBounds().getX() == 120;
            screenSettings.getMapBounds().getY() == 240;
    }

    def "Screen set Y min"() {

        when:
            screenSettings.setYmin(10);
        then:
            screenSettings.getYmin() == 10;
    }

    def "Screen set X min"() {

        when:
            screenSettings.setXmin(17);
        then:
            screenSettings.getXmin() == 17;
    }
}