package com.g801.supaplex.Controller.Display;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.GameWinMenu;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.States.GameWinMenuState;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.IOException;

public class MurphyController extends Controller<Display> {

    public MurphyController(Display model){
        super(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        if (canMove(keyaction, game)) {

            Position oldPos = new Position(getModel().getMurphy().getPos().getX(), getModel().getMurphy().getPos().getY());
            Murphy murphy = this.getModel().getMurphy();
            Model[][] map = this.getModel().getMap();
            Position newPos = oldPos;

            switch(keyaction) {
                case DOWN -> murphy.moveDown();
                case UP ->murphy.moveUp();
                case LEFT -> murphy.moveLeft();
                case RIGHT -> murphy.moveRight();
                case EAT_LEFT -> newPos = oldPos.getLeft();
                case EAT_RIGHT -> newPos = oldPos.getRight();
                case EAT_UP -> newPos = oldPos.getUp();
                case EAT_DOWN -> newPos = oldPos.getDown();
            }

            if (newPos != murphy.getPos()) {
                map[newPos.getY()][newPos.getX()] = new Base(newPos);
                getModel().update(murphy, keyaction);
            }
            getModel().updateTopLeft();
        }
    }

    public boolean canMove(GUI.KEYACTION keyaction, Game game){

        Position pos = getModel().getMurphy().getPos();
        Position newPos = pos;
        Model[][] map = getModel().getMap();

        switch(keyaction) {
            case UP, EAT_UP -> newPos = pos.getUp();
            case DOWN, EAT_DOWN -> newPos = pos.getDown();
            case LEFT, EAT_LEFT -> newPos = pos.getLeft();
            case RIGHT, EAT_RIGHT -> newPos = pos.getRight();
        }

        Model model = map[newPos.getY()][newPos.getX()];
        if (model instanceof Infotron) {
            this.soundPlayer.decreaseInfotronSound();
            getModel().decrementInfotronCount();
        }

        return (model instanceof Chip || model instanceof Base || model instanceof Infotron ||
                (model instanceof EndBlock && checkInfotronCount(game)));
    }

    boolean checkInfotronCount(Game game) {
        if (getModel().getInfotronCount() == 0) {
            this.soundPlayer.playGameWinSound();
            game.pushState(new GameWinMenuState(new GameWinMenu()));
        }
        return false;
    }
}