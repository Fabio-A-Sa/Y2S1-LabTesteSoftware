package com.g801.supaplex.Controller.Menu

import com.g801.supaplex.Game
import com.g801.supaplex.Model.Menu.MainMenu
import com.g801.supaplex.Viewer.GUI.GUI
import spock.lang.Specification

class MenuControllerTest extends Specification {

    private MainMenuController menuController;
    private MainMenu mainMenu;
    private Game game;
    private time = 900000;

    def setup() {
        game = Mock(Game.class);
        mainMenu = Mock(MainMenu.class);
        menuController = new MainMenuController(mainMenu);
    }

    def "Main Menu receives DOWN key pressed"() {

        when:
            menuController.execute(game, GUI.KEYACTION.DOWN, time);
        then:
            1 * mainMenu.downButton();
    }

    def "Main Menu receives UP key pressed"() {

        when:
            menuController.execute(game, GUI.KEYACTION.UP, time);
        then:
            1 * mainMenu.upButton();
    }

    def "Let's begin the game"() {

        given:
            mainMenu.getCurrentSelect() >> "START";
        when:
            menuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            1 * game.pushState(_);
    }

    def "Let's select a level"() {

        given:
            mainMenu.getCurrentSelect() >> "LEVEL";
        when:
            menuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            0 * game.pushState(_);
            0 * game.getConfiguration();
    }
}