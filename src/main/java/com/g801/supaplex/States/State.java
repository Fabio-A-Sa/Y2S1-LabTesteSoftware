package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Game;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import java.io.IOException;

public abstract class State<T> {

    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }
    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.KEYACTION keyaction = gui.getNextAction();
        controller.execute(game, keyaction, time);
        viewer.draw(gui);
    }
}
