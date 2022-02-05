package com.g801.supaplex.Controller.Menu

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Configuration
import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.Viewer.GUI.GUI;
import spock.lang.Specification;

class SelectLevelMenuControllerTest extends Specification {

    private SelectLevelMenuController controller;
    private Configuration fakeConfiguration;
    private SelectLevelMenu menu;
    private Game game;
    private time = 900000;

    def setup() {
        game = Mock(Game.class);
        menu = Mock(SelectLevelMenu.class);
        fakeConfiguration = Mock(Configuration.class);
        menu.getConfiguration() >> fakeConfiguration;
        controller = new SelectLevelMenuController(menu);
    }

    def "Level Menu receives DOWN key pressed"() {

        when:
            controller.execute(game, GUI.KEYACTION.DOWN, time);
        then:
            1 * menu.downButton();
    }

    def "Level Menu receives UP key pressed"() {

        when:
            controller.execute(game, GUI.KEYACTION.UP, time);
        then:
            1 * menu.upButton();
    }

    def "Decreasing the chosen level"() {

        given:
            menu.getCurrentSelect() >> "LOWER";
        when:
            controller.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            1 * fakeConfiguration.lowerCurrentLevel();
    }

    def "Increasing the chosen level"() {

        given:
            menu.getCurrentSelect() >> "INCREASE";
        when:
            controller.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            1 * fakeConfiguration.increaseCurrentLevel();
    }

    def "Back to the main menu"() {

        given:
            menu.getCurrentSelect() >> "BACK";
        when:
            controller.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            1 * game.popState();
    }
}