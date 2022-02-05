package com.g801.supaplex.Controller.Menu;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.IOException;

public class SelectLevelMenuController extends Controller<Menu> {

    public SelectLevelMenuController(SelectLevelMenu model) {
        super(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

       Menu model = getModel();

        switch(keyaction) {
            case DOWN -> model.downButton();
            case UP -> model.upButton();
            case SELECT -> {
                switch (model.getCurrentSelect()) {
                    case "LOWER" -> model.getConfiguration().lowerCurrentLevel();
                    case "INCREASE" -> model.getConfiguration().increaseCurrentLevel();
                    case "BACK" -> game.popState();
                }
            }
        }
    }
}
