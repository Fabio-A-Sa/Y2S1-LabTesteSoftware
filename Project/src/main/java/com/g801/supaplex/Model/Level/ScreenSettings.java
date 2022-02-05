package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Position;

public class ScreenSettings{

    private static Integer width;
    private static Integer height;
    private static Position mapBounds;
    private static Position displayTopleft;

    public ScreenSettings(){

        displayTopleft = new Position(0,0);
        width = 7;
        height = 9;
    }

    public Integer getWidth(){
        return width;
    }

    public Integer getHeight(){
        return height;
    }

    public Integer getYmin(){
        return displayTopleft.getY();
    }

    public Integer getXmin(){
        return displayTopleft.getX();
    }

    public Position getMapBounds(){
        return mapBounds;
    }

    public void setYmin(Integer y){
        displayTopleft.setY(y);
    }

    public void setXmin(Integer x){
        displayTopleft.setX(x);
    }

    public void setMapBounds(Integer x, Integer y){
        mapBounds = new Position(x, y);
    }

    public static void setHeight(Integer h) {
        height = h;
    }

    public static void setWidth(Integer w) {
        width = w;
    }
}