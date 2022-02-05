package com.g801.supaplex.Model.Menu;

public class SelectLevelMenu extends Menu {

    public SelectLevelMenu() {
        super();
        this.selected = "LOWER";
        this.optString = new String[]{"LOWER", "INCREASE", "BACK"};
        title = "SELECT LEVEL";
    }
}