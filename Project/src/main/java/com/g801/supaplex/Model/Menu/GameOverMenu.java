package com.g801.supaplex.Model.Menu;

public class GameOverMenu extends Menu {

    public GameOverMenu() {
        super();
        this.selected = "RESTART LEVEL";
        this.optString = new String[]{"RESTART LEVEL", "RETURN TO MENU"};
        title = " YOU LOST :( ";
    }
}