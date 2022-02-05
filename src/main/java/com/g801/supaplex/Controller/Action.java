package com.g801.supaplex.Controller;

import com.g801.supaplex.Model.Elements.Movable;

public class Action {

    public enum Actions {
        MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT
    }

    private static Movable movable;

    public Action(Movable m){
        movable = m;
    }

    public Movable getMovable() { return movable;}

    public void factory(Actions action) {
        if (movable.canMove(action)) {
            switch (action) {
                case MOVE_UP -> movable.moveUp();
                case MOVE_DOWN -> movable.moveDown();
                case MOVE_LEFT -> movable.moveLeft();
                case MOVE_RIGHT -> movable.moveRight();
            }
        }
    }
}