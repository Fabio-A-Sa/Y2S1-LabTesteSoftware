package com.g801.supaplex.Model.Menu

import spock.lang.Specification;

class SelectLevelMenuTest extends Specification {

    private SelectLevelMenu menu;

    def setup() {
        menu = new SelectLevelMenu();
    }

    def "Initial level menu State"() {

        expect:
            menu.getCurrentSelect() == "LOWER";
            menu.getTextImagesList().size() != 0;
    }

    def "Position of options in level menu"() {

        expect:
            menu.getPosElem(a) == b;

        where:
            a           | b
            "LOWER"     | 0
            "INCREASE"  | 1
            "BACK"      | 2
    }

    def "Select another option"() {

        when:
            menu.setSelected("INCREASE");
        then:
            menu.getCurrentSelect() == "INCREASE";

        when:
            menu.setSelected("BACK");
        then:
            menu.getCurrentSelect() == "BACK";
    }

    def "Return all options"() {

        expect:
            menu.getOptString()[a] == b

        where:
            a | b
            0 | "LOWER"
            1 | "INCREASE"
            2 | "BACK"
    }

    def "Upper Button Click"() {

        expect:
            menu.setSelected(a);
            menu.upButton();
            menu.getCurrentSelect() == b;

        where:
            a | b
            "LOWER" | "BACK"
            "INCREASE" | "LOWER"
            "BACK" | "INCREASE"
    }

    def "Down Button Click"() {

        expect:
            menu.setSelected(a);
            menu.downButton();
            menu.getCurrentSelect() == b;

        where:
            a | b
            "LOWER" | "INCREASE"
            "INCREASE" | "BACK"
            "BACK" | "LOWER"
    }
}