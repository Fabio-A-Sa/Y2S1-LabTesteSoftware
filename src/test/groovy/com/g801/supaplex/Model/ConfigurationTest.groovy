package com.g801.supaplex.Model

import com.g801.supaplex.Model.Elements.Murphy
import spock.lang.Specification;

class ConfigurationTest extends Specification {

    private Configuration configuration;
    private Murphy murphy;
    private Position bounds;

    def setup() {
        configuration = Configuration.getInstance();
        murphy = Mock(Murphy.class);
        bounds = new Position(24, 15);
    }

    def cleanup() {
        Configuration.reset();
    }

    def "Initial configurations"() {

        given:
            configuration.setMapBounds(24, 15);

        expect:
            configuration.getCurrentLevel() == 1;
            configuration.getScreenLowerBound() != null;
            configuration.getMapBounds() == new Position(24, 15);
    }

    def "Murphy is in the middle of the map"() {

        given:
            murphy.getPos() >> new Position(11, 7);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 8;
            configuration.getYmin() == 3;
    }

    def "Murphy is in the upper left corner"() {

        given:
            murphy.getPos() >> new Position(3, 2);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 0;
            configuration.getYmin() == 0;
    }

    def "Murphy is in the upper right corner"() {

        given:
            murphy.getPos() >> new Position(22, 2);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 17;
            configuration.getYmin() == 0;
    }

    def "Murphy is in the lower left corner"() {

        given:
            murphy.getPos() >> new Position(4, 12);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 1;
            configuration.getYmin() == 6;
    }

    def "Murphy is in the lower right corner"() {

        given:
            murphy.getPos() >> new Position(24, 14);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 17;
            configuration.getYmin() == 6;
    }

    def "Increasing current level"() {

        expect:
            while (a) {
                configuration.increaseCurrentLevel()
                a--;
            };
            configuration.getCurrentLevel() == b;
        where:
            a | b
            1 | 2
            2 | 3
            3 | 4
            1 | 2
    }

    def "Decreasing current level"() {

        expect:
            while (a) {
                configuration.lowerCurrentLevel()
                a--;
            };
            configuration.getCurrentLevel() == b;
        where:
            a | b
            1 | 7
            2 | 6
            3 | 5
            4 | 4
    }
}