package com.g801.supaplex.Model.Menu;

public class PauseMenu extends Menu {

    public PauseMenu() {
        super();
        this.selected = "CONTINUE GAME";
        this.optString = new String[]{"CONTINUE GAME", "RESTART", "RETURN TO MENU"};
        title = "PAUSED";
    }
}