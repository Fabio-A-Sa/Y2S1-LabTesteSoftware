package com.g801.supaplex.Model.Models

import com.g801.supaplex.Model.Position;
import spock.lang.Specification

class ModelTest extends Specification {

    private Position position;
    private Model model;

    def setup() {
        model = new Model();
        position = new Position(10, 20);
    }

    def "Initial configuration"() {

        expect:
            model.getModel() == null;
            model.getPos() == null;
    }

    def "New Position"() {

        given:
            model.setPos(position);
        expect:
            model.getPos() == new Position(10, 20);
    }
}