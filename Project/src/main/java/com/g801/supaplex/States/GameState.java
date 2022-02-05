package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.Display.GameController;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Viewer.MapViewer.DisplayViewer;
import com.g801.supaplex.Viewer.Viewer;

public class GameState extends State<Display> {

    public GameState(Display model) {
        super(model);
    }

    @Override
    protected Viewer<Display> getViewer() {
        return new DisplayViewer(getModel());
    }

    @Override
    protected Controller<Display> getController() {
        return new GameController(getModel());
    }
}
