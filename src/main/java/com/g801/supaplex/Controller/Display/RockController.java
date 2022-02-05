package com.g801.supaplex.Controller.Display;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.IOException;

public class RockController extends ElementController {

    public RockController(Display model) {
        super(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        Display model = getModel();
        for (Rock elem : model.getRockList()) {
            if (canMoveDown(elem)) {
                this.soundPlayer.playFallSound();
                elem.moveDown();
                model.updateRock(elem);
            }
            else if (canMoveRight(elem)) {
                elem.moveRight(); elem.moveDown();
                model.updateRockRight(elem);
            }
            else if (canMoveLeft(elem)) {
                elem.moveLeft(); elem.moveDown();
                model.updateRockLeft(elem);
            }
        }
    }

    public boolean canMoveDown(Rock elem){
        Position pos = elem.getPos().getDown();
        return getModel().getMap()[pos.getY()][pos.getX()] instanceof Base;
    }

    public boolean canMoveRight(Rock elem) {
        Model[][] map = getModel().getMap();
        Position pos = elem.getPos();
        return map[pos.getY() + 1][pos.getX()] instanceof Rock && map[pos.getRight().getY()][pos.getRight().getX()] instanceof Base
                && map[pos.getRight().getY()+1][pos.getRight().getX()] instanceof Base;
    }

    public boolean canMoveLeft(Rock elem) {
        Model[][] map = getModel().getMap();
        Position pos = elem.getPos();
        return map[pos.getY() + 1][pos.getX()] instanceof Rock && map[pos.getLeft().getY()][pos.getLeft().getX()] instanceof Base
                && map[pos.getLeft().getY()+1][pos.getLeft().getX()] instanceof Base;
    }
}