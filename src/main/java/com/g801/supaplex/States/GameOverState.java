package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.Menu.GameOverMenuController;
import com.g801.supaplex.Model.Menu.GameOverMenu;
import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Viewer.Menu.MenuViewer;
import com.g801.supaplex.Viewer.Viewer;

public class GameOverState extends State<Menu> {

    public GameOverState(GameOverMenu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new GameOverMenuController(getModel());
    }
}
