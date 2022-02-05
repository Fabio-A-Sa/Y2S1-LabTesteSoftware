package com.g801.supaplex.Model.Aura

import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Model.Configuration
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Elements.Wall;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position
import spock.lang.Specification;

class AuraTest extends Specification {

    private Murphy murphy;
    private Aura aura;
    private List<Model> modelsList;

    def setup() {

        Configuration configuration = Configuration.getInstance();
        configuration.setMapBounds(17, 17);
        murphy = Mock(Murphy.class);
        murphy.getPos() >> new Position(10, 10);
        aura = new Aura(murphy);
        modelsList = new ArrayList<Model>(4);
        Model m1 = new Wall(new Position(10, 9)); modelsList.push(m1);
        Model m2 = new Wall(new Position(10, 11)); modelsList.push(m2);
        Model m3 = new Wall(new Position(9, 10)); modelsList.push(m3);
        Model m4 = new Wall(new Position(11, 10)); modelsList.push(m4);
        aura.aura = modelsList;
    }

    def "Aura Initial Size"() {

        expect:
            aura.aura.size() == 4;
    }

    def "Can Move Up?"() {

        expect:
            !aura.canMove(Action.Actions.MOVE_UP);

        when:
            aura.aura[0] = new Model();

        then:
            aura.canMove(Action.Actions.MOVE_UP);
    }

    def "Can Move Down?"() {

        expect:
            !aura.canMove(Action.Actions.MOVE_DOWN);

        when:
            aura.aura[1] = new Model();

        then:
            aura.canMove(Action.Actions.MOVE_DOWN);
    }

    def "Can Move Right?"() {

        expect:
            !aura.canMove(Action.Actions.MOVE_RIGHT);

        when:
            aura.aura[3] = new Model();

        then:
            aura.canMove(Action.Actions.MOVE_RIGHT);
    }

    def "Can Move Left?"() {

        expect:
            !aura.canMove(Action.Actions.MOVE_LEFT);

        when:
            aura.aura[2] = new Model();

        then:
            aura.canMove(Action.Actions.MOVE_LEFT);
    }
}