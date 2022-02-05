package com.g801.supaplex.Controller.Display;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Elements.Base;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Elements.Scissors;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.GameOverMenu;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.States.GameOverState;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class ScissorController extends ElementController {

    public ScissorController(Display model) {
        super(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        for (Scissors elem : getModel().getScissorList()) {
            if (canMove(elem, game)) {
                switch(elem.getDirection()) {
                    case RIGHT -> elem.moveRight();
                    case LEFT -> elem.moveLeft();
                    case UP -> elem.moveUp();
                    case DOWN -> elem.moveDown();
                }
                getModel().updateScissor(elem);
            }
        }
    }

    public boolean canMove(Scissors elem, Game game) {

        Model[][] map = getModel().getMap();
        Position oldPos = elem.getPos();
        Position newPos = oldPos;
        char sprite = ' ';
        Scissors.Direction direction = elem.getDirection();

        switch (elem.getDirection()) {

            case RIGHT -> {
                newPos = oldPos.getRight();
                sprite = '1';
                direction = Scissors.Direction.DOWN;
            }
            case LEFT -> {
                newPos = oldPos.getLeft();
                direction = Scissors.Direction.UP;
                sprite = 'X';
            }
            case UP -> {
                newPos = oldPos.getUp();
                direction = Scissors.Direction.RIGHT;
                sprite = '2';
            }
            case DOWN -> {
                newPos = oldPos.getDown();
                direction = Scissors.Direction.LEFT;
                sprite = '3';
            }
        }

        Model model = map[newPos.getY()][newPos.getX()];
        if (model instanceof Murphy) game.pushState(new GameOverState(new GameOverMenu()));
        if (!(model instanceof Base)) {
            elem.setDirection(direction);
            elem.setSprite(sprite);
            return false;
        }
        return true;
    }
}