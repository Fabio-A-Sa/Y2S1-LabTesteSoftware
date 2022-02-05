package com.g801.supaplex.States

import com.g801.supaplex.Controller.Display.GameController
import com.g801.supaplex.Model.Level.Display
import com.g801.supaplex.Viewer.MapViewer.DisplayViewer
import spock.lang.Specification;

class GameStateTest extends Specification {

    private GameState gameState;

    def setup() {
        gameState = new GameState(new Display());
    }

    def "Game States"() {

        expect:
            gameState.getModel() instanceof Display;
            gameState.getViewer() instanceof DisplayViewer;
            gameState.getController() instanceof GameController;
    }
}