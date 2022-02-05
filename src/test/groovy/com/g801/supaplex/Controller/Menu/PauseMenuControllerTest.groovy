package com.g801.supaplex.Controller.Menu;

import com.g801.supaplex.Game
import com.g801.supaplex.Model.Menu.PauseMenu
import com.g801.supaplex.Viewer.GUI.GUI
import spock.lang.Specification

class PauseMenuControllerTest extends Specification {

    private PauseMenuController menuController;
    private PauseMenu pauseMenu;
    private Game game;
    private time = 900000;

    def setup() {
        game = Mock(Game.class);
        pauseMenu = Mock(PauseMenu.class);
        menuController = new PauseMenuController(pauseMenu);
    }

    def "Pause Menu receives DOWN key pressed"() {

        when:
            menuController.execute(game, GUI.KEYACTION.DOWN, time);
        then:
            1 * pauseMenu.downButton();
    }

    def "Pause Menu receives UP key pressed"() {

        when:
            menuController.execute(game, GUI.KEYACTION.UP, time);
        then:
            1 * pauseMenu.upButton();
    }

    def "Let's continue the game!"() {

        given:
            pauseMenu.getCurrentSelect() >> "CONTINUE";
        when:
            menuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            0 * game.popState();
    }

    def "Let's restart the game!"() {

        given:
            pauseMenu.getCurrentSelect() >> "RESTART";
        when:
            menuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            1 * game.pushState(_);
    }

    def "Let's quit the game!"() {

        given:
            pauseMenu.getCurrentSelect() >> "QUIT";
        when:
            menuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            0 * game.popState();
    }
}