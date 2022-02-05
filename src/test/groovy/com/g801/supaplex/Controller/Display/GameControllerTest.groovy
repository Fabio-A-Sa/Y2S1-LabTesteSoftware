package com.g801.supaplex.Controller.Display

import com.g801.supaplex.Game
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Viewer.GUI.GUI;
import spock.lang.Specification;

class GameControllerTest extends Specification {

    private GameController gameController;
    private Display display;
    private Game game;
    private int time = 10000;

    def setup() {
        game = Mock(Game.class);
        display = Mock(Display.class);
        gameController = new GameController(display);
    }

    def "Initial state"() {

        expect:
            gameController.getModel() == display;

        when:
            Display anotherDisplay = new Display();
            gameController.setModel(anotherDisplay);

        then:
            gameController.getModel() == anotherDisplay;
    }

    def "Pause the Game"() {

        when:
            gameController.execute(game, GUI.KEYACTION.PAUSE, time);
        then:
            1 * game.pushState(_);
    }

    def "Restart the Game"() {

        when:
            gameController.execute(game, GUI.KEYACTION.RESTART, time);
        then:
            1 * game.popState();
            1 * game.pushState(_);
    }
}