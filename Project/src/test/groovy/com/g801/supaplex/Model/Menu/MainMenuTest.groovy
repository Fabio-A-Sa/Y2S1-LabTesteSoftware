package com.g801.supaplex.Model.Menu

import com.g801.supaplex.Model.Image
import spock.lang.Specification;

class MainMenuTest extends Specification {

    private MainMenu menu;

    def setup() {
        menu = new MainMenu();
    }

    def "Initial menu State"() {

        expect:
            menu.getCurrentSelect() == "START";
            menu.getTextImagesList().size() == 21;
    }


    def "Select another option"() {

        when:
            menu.setSelected("LEVEL");
        then:
            menu.getCurrentSelect() == "LEVEL";

        when:
            menu.setSelected("EXIT");
        then:
            menu.getCurrentSelect() == "EXIT";
    }

    def "Return all options"() {

        expect:
            menu.getOptString()[a] == b

        where:
            a | b
            0 | "START"
            1 | "SELECT LEVEL"
            2 | "QUIT"
    }

    def "Return all string options"() {

        expect:
            menu.getOptString()[a] == b

        where:
            a | b
            0 | "START"
            1 | "SELECT LEVEL"
            2 | "QUIT"
    }

    def "Upper Button Click"() {

        expect:
            menu.setSelected(a);
            menu.upButton();
            menu.getCurrentSelect() == b;

        where:
                  a | b
            "START" | "QUIT"
            "SELECT LEVEL" | "START"
            "QUIT"  | "SELECT LEVEL"
    }

    def "Down Button Click"() {

        expect:
            menu.setSelected(a);
            menu.downButton();
            menu.getCurrentSelect() == b;

        where:
                  a | b
            "START" | "SELECT LEVEL"
            "SELECT LEVEL" | "QUIT"
            "QUIT"  | "START"

    }

    def "Images content"() {

        given:
            List<Image> allImages = menu.getTextImagesList();

        expect:
            allImages.size() == 21;
            for (Image image : allImages) {
                assert image.getBitMap() != null
                assert image.getPosition() != null
            }
    }
}