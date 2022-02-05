package com.g801.supaplex.Model.Menu;
public class MainMenu extends Menu {

    public MainMenu() {
        super();
        this.selected = "START";
        this.optString = new String[]{"START", "SELECT LEVEL", "QUIT"};
        title = "SUPAPL0X";
    }
}
