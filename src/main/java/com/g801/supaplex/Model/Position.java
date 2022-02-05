package com.g801.supaplex.Model;

import java.util.Objects;

public class Position {
    private Integer x, y;

    public Position(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer getX(){
        return x;
    }

    public Integer getY(){
        return y;
    }

    public void setX(Integer n){
        x = n;
    }

    public void setY(Integer n){
        y = n;
    }

    public void addX(Integer n){
        x += n;
    }

    public void addY(Integer n){
        y += n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) && Objects.equals(y, position.y);
    }

    public Position getDown() {
        return new Position(this.x, this.y + 1);
    }

    public Position getUp() {
        return new Position(this.x, this.y - 1);
    }

    public Position getRight() {
        return new Position(this.x + 1, this.y);
    }

    public Position getLeft() {
        return new Position(this.x - 1, this.y);
    }
}
