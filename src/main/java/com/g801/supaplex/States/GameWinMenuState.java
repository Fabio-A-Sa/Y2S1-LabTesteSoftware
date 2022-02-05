package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.Menu.GameWinMenuController;
import com.g801.supaplex.Model.Menu.GameWinMenu;
import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Viewer.Menu.MenuViewer;
import com.g801.supaplex.Viewer.Viewer;

public class GameWinMenuState extends State<Menu> {

    public GameWinMenuState(GameWinMenu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new GameWinMenuController((GameWinMenu) getModel());
    }
}
