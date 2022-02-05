package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.Menu.PauseMenuController;
import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Model.Menu.PauseMenu;

import com.g801.supaplex.Viewer.Menu.MenuViewer;
import com.g801.supaplex.Viewer.Viewer;

public class PauseMenuState extends State<Menu> {

    public PauseMenuState(PauseMenu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new PauseMenuController((PauseMenu) getModel());
    }
}
