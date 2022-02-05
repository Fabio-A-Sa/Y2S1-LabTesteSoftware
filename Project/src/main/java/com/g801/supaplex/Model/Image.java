package com.g801.supaplex.Model;

public class Image {

    private final char [][] bitMap;
    private final Position position;

    public Image(Position position, char [][] bitMap) {
        this.position = position;
        this.bitMap = bitMap;
    }

    public Position getPosition() {
        return position;
    }

    public char[][] getBitMap() {
        return bitMap;
    }
}