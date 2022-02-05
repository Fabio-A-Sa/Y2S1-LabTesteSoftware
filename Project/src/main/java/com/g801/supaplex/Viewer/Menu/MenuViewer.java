package com.g801.supaplex.Viewer.Menu;

import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.Objects;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu model) {
        super(model);
    }

    @Override
    public void drawModel(GUI gui) throws IOException {
        Size size = gui.getSize();
        Screen screen = gui.getScreen();
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString((size.getWidth() - getModel().getTitle().length())/ 2 + 1, 7, getModel().getTitle(), SGR.BOLD);
        gui.drawTitleBorder();

        int y = 10;

        for (String elem : getModel().getOptString()) {
            if (Objects.equals(getModel().getCurrentSelect(), elem)) {
                gui.drawStringCentered(TextColor.ANSI.BLUE_BRIGHT, y, elem);
            } else gui.drawStringCentered(TextColor.ANSI.RED_BRIGHT, y, elem);
            y += 2;
        }

        if (getModel() instanceof SelectLevelMenu)  gui.drawStringCentered(TextColor.ANSI.RED_BRIGHT, y, "CURRENT LVL: " + getModel().getConfiguration().getCurrentLevel());

        gui.drawImages(getModel().getTextImagesList());
    }
}
