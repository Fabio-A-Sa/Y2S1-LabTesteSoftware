package com.g801.supaplex.Model

import spock.lang.Specification;

class PositionTest extends Specification {

    private Position position;

    def setup() {
        this.position = new Position(10, 20);
    }

    def "Get X"() {

        given:
            this.position;
        when:
            double x = position.getX();
        then:
            x == 10.0;
    }

    def "Get Y"() {

        given:
            this.position;
        when:
            double y = position.getY();
        then:
            y == 20;
    }

    def "Increment X"() {

        given:
            this.position;
        when:
            position.addX(-2);
            double x = position.getX();
            position.addX(12);
        then:
            x == 8;
            position.getX() == 20;
    }

    def "Increment Y"() {

        given:
            this.position;
        when:
            position.addY(-30);
            double y = position.getY();
            position.addY(23);
        then:
            y == -10;
            position.getY() == 13;
    }
}