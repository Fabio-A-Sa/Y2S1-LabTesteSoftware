package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.Menu.SelectLevelMenuController;
import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.Viewer.Menu.MenuViewer;

import com.g801.supaplex.Viewer.Viewer;

public class SelectLevelMenuState extends State<Menu> {

    public SelectLevelMenuState(SelectLevelMenu model) {
            super(model);
        }

    @Override
    protected Viewer<Menu> getViewer() {
            return new MenuViewer(getModel());
        }

    @Override
    protected Controller<Menu> getController() {
            return new SelectLevelMenuController((SelectLevelMenu) getModel());
        }
}