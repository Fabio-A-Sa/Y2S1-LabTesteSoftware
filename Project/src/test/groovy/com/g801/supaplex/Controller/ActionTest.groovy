package com.g801.supaplex.Controller;

import com.g801.supaplex.Model.Elements.Movable
import spock.lang.Specification

class ActionTest extends Specification {

    private Action action;
    private Movable movable;

    def setup() {

        movable = Mock(Movable.class);
        movable.canMove(_) >> true;
        action = new Action(movable);
    }

    def "Initial configuration"() {

        expect:
            movable.canMove(Action.Actions.MOVE_LEFT);
            action.getMovable().equals(movable);
    }

    def "Move Left"() {

        when:
            action.factory(Action.Actions.MOVE_LEFT);
        then:
            1 * movable.moveLeft();
    }

    def "Move Right"() {

        when:
            action.factory(Action.Actions.MOVE_RIGHT);
        then:
            1 * movable.moveRight();
    }

    def "Move Up"() {

        when:
            action.factory(Action.Actions.MOVE_UP);
        then:
            1 * movable.moveUp();
    }

    def "Move Down"() {

        when:
            action.factory(Action.Actions.MOVE_DOWN);
        then:
            1 * movable.moveDown();
    }
}