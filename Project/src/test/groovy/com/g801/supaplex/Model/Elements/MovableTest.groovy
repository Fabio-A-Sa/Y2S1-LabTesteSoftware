package com.g801.supaplex.Model.Elements

import com.g801.supaplex.Model.Models.Sprite
import com.g801.supaplex.Model.Position;
import spock.lang.Specification

class MovableTest extends Specification {

    private Movable movable;
    private int x = Sprite.width;
    private int y = Sprite.height;
    private int originalX = 10;
    private int originalY = 10;

    def setup () {
        movable = new Movable();
        movable.setPos(new Position(originalX, originalY));
    }

    def "Initial state"() {

        expect:
            movable.getPos() == new Position(originalX, originalY);
            movable.getModel() != null;
    }

    def "Move Left"() {

        when:
            movable.moveLeft();
        then:
            movable.getPos() == new Position(9, 10);
    }

    def "Move Right"() {

        when:
            movable.moveRight();
        then:
            movable.getPos() == new Position(11, 10);
    }

    def "Move Up"() {

        when:
            movable.moveUp();
        then:
            movable.getPos() == new Position(10, 9);
    }

    def "Move Down"() {

        when:
            movable.moveDown();
        then:
            movable.getPos() == new Position(10, 11);
    }
}