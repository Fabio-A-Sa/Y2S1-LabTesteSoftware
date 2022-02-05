package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.Menu.MainMenuController;
import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Viewer.Menu.MenuViewer;
import com.g801.supaplex.Viewer.Viewer;

public class MenuState extends State<Menu> {

    public MenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MainMenuController((MainMenu) getModel());
    }
}
