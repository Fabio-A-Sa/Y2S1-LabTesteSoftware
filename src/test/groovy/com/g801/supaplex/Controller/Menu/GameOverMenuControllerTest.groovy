package com.g801.supaplex.Controller.Menu;

import com.g801.supaplex.Game
import com.g801.supaplex.Model.Menu.GameOverMenu
import com.g801.supaplex.Viewer.GUI.GUI
import spock.lang.Specification;

class GameOverMenuControllerTest extends Specification {

    private long time;
    private Game game;
    private GameOverMenuController gameOverMenuController;
    private GameOverMenu gameOverMenu;

    def setup() {
        time = 9000;
        game = new Game();
        //game.pushState(new GameState(new Display()));
        //game.pushState(new GameState(new Display()));
        gameOverMenu = Mock(GameOverMenu.class);
        gameOverMenuController = new GameOverMenuController(gameOverMenu);
    }

    def "Key Down"() {

        when:
            gameOverMenuController.execute(game, GUI.KEYACTION.DOWN, time);
        then:
            1 * gameOverMenu.downButton();
    }

    def "Key Up"() {

        when:
            gameOverMenuController.execute(game, GUI.KEYACTION.UP, time);
        then:
            1 * gameOverMenu.upButton();
    }

    def "Key Select -> Restart"() {

        given:
            gameOverMenu.getCurrentSelect() >> "RESTART";
        when:
            gameOverMenuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            0 * game.popState();
            0 * game.pushState(_);
    }
}