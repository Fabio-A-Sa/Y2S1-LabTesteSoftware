package com.g801.supaplex.Model.Menu

import com.g801.supaplex.Model.Image
import spock.lang.Specification;

class PauseMenuTest extends Specification {

    private PauseMenu menu;

    def setup() {
        menu = new PauseMenu();
    }

    def "Initial Pause menu State"() {

        expect:
            menu.getCurrentSelect() == "CONTINUE GAME";
            menu.getTextImagesList().size() == 21;
    }

    def "Select another option"() {

        when:
            menu.setSelected("RESTART");
        then:
            menu.getCurrentSelect() == "RESTART";

        when:
            menu.setSelected("RESTART");
        then:
            menu.getCurrentSelect() == "RESTART";
    }

    def "Return all options"() {

        expect:
            menu.getOptString()[a] == b

        where:
            a | b
            0 | "CONTINUE GAME"
            1 | "RESTART"
            2 | "RETURN TO MENU"
    }

    def "Return all string options"() {

        expect:
            menu.getOptString()[a] == b

        where:
            a | b
            0 | "CONTINUE GAME"
            1 | "RESTART"
            2 | "RETURN TO MENU"
    }

    def "Upper Button Click"() {

        expect:
            menu.setSelected(a);
            menu.upButton();
            menu.getCurrentSelect() == b;

        where:
                       a | b
            "CONTINUE GAME"   | "RETURN TO MENU"
            "RETURN TO MENU"       | "RESTART"
            "RESTART"    | "CONTINUE GAME"
    }

    def "Down Button Click"() {

        expect:
            menu.setSelected(a);
            menu.downButton();
            menu.getCurrentSelect() == b;

        where:
                       a | b
            "CONTINUE GAME"   | "RESTART"
            "RESTART"    | "RETURN TO MENU"
            "RETURN TO MENU"       | "CONTINUE GAME"

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