package com.g801.supaplex.Model.Menu;

public class GameWinMenu extends Menu {

    public GameWinMenu() {
        super();
        this.selected = "NEXT LEVEL";
        this.optString = new String[]{"NEXT LEVEL", "RETURN TO MAIN MENU", "QUIT"};
        title = "!!! YOU WON!!!";
    }
}
