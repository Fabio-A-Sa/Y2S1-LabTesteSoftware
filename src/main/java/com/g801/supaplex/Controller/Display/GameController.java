package com.g801.supaplex.Controller.Display;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.PauseMenu;
import com.g801.supaplex.Model.Audio.SoundPlayer;
import com.g801.supaplex.States.GameState;
import com.g801.supaplex.States.PauseMenuState;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class GameController extends Controller<Display> {

    private final MurphyController murphyController;
    private final RockController rockController;
    private final ScissorController scissorController;

    public GameController(Display model) {
        super(model);
        this.murphyController = new MurphyController(model);
        this.rockController = new RockController(model);
        this.scissorController = new ScissorController(model);
        this.soundPlayer = new SoundPlayer();
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        switch(keyaction) {
            case PAUSE -> game.pushState(new PauseMenuState(new PauseMenu()));
            case RESTART -> {
                game.popState();
                game.pushState(new GameState(new Display()));
            }
            default -> {
                murphyController.execute(game, keyaction, time);
                rockController.execute(game, keyaction, time);
                scissorController.execute(game, keyaction, time);
            }
        }
    }
}
