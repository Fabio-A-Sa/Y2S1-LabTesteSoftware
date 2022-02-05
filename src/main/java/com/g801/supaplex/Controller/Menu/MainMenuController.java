package com.g801.supaplex.Controller.Menu;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.States.GameState;
import com.g801.supaplex.States.SelectLevelMenuState;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.IOException;

public class MainMenuController extends Controller<Menu> {

    public MainMenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        Menu model = getModel();

        switch(keyaction) {
            case DOWN -> model.downButton();
            case UP -> model.upButton();
            case SELECT -> {
                switch (model.getCurrentSelect()) {
                    case "START" -> game.pushState(new GameState(new Display()));
                    case "SELECT LEVEL" -> game.pushState(new SelectLevelMenuState(new SelectLevelMenu()));
                    case "QUIT" -> System.exit(0);
                }
            }
        }
    }
}