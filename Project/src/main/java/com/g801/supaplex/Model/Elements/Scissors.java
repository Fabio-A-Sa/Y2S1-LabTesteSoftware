package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class Scissors extends Movable {

    public enum Direction {
        RIGHT, LEFT, UP, DOWN
    }

    private Direction direction = Direction.RIGHT;

    public Scissors(Position p){
        super.model = SpriteFactory.factoryMethod('X');
        super.pos = p;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }
}