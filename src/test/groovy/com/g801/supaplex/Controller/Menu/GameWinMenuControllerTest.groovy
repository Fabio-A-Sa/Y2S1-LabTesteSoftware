package com.g801.supaplex.Controller.Menu;

import com.g801.supaplex.Game
import com.g801.supaplex.Model.Configuration
import com.g801.supaplex.Model.Level.Display
import com.g801.supaplex.Model.Menu.GameWinMenu
import com.g801.supaplex.States.GameState
import com.g801.supaplex.Viewer.GUI.GUI
import spock.lang.Specification;

class GameWinMenuControllerTest extends Specification {

    private long time;
    private Game game;
    private GameWinMenuController gameWinMenuController;
    private GameWinMenu gameWinMenu;

    def setup() {
        time = 9000;
        game = new Game();
        game.pushState(new GameState(new Display()));
        game.pushState(new GameState(new Display()));
        gameWinMenu = Mock(GameWinMenu.class);
        gameWinMenuController = new GameWinMenuController(gameWinMenu);
    }

    def cleanup() {
        Configuration.reset();
    }

    def "Key Down"() {

        when:
            gameWinMenuController.execute(game, GUI.KEYACTION.DOWN, time);
        then:
            1 * gameWinMenu.downButton();
    }

    def "Key Up"() {

        when:
            gameWinMenuController.execute(game, GUI.KEYACTION.UP, time);
        then:
            1 * gameWinMenu.upButton();
    }

    def "Key Select -> Next Level"() {

        given:
            gameWinMenu.getCurrentSelect() >> "NEXT LEVEL";
        when:
            gameWinMenuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            0 * game.popState();
            0 * game.pushState(_);
    }

    def "Key Select -> Return to main menu"() {

        given:
        gameWinMenu.getCurrentSelect() >> "RETURN TO MAIN MENU";
        when:
        gameWinMenuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
        0 * game.popState();
        0 * game.pushState(_);
    }
}