package com.g801.supaplex.Model;

import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Level.ScreenSettings;

public class Configuration {

    private static Configuration confs;
    private static ScreenSettings displayConfig;
    private Integer currentLevel;
    private final Integer NUM_LEVELS = 7;

    private Configuration() {
        this.currentLevel = 1;
        displayConfig = new ScreenSettings();
    }

    public static Configuration getInstance(){
        if (confs == null)
            confs = new Configuration();
        return confs;
    }

    public Integer getWidth(){
        return displayConfig.getWidth();
    }

    public Integer getHeight(){
        return displayConfig.getHeight();
    }

    public Integer getYmin(){
        return displayConfig.getYmin();
    }

    public Integer getXmin(){
        return displayConfig.getXmin();
    }

    public Position getMapBounds(){
        return displayConfig.getMapBounds();
    }

    private void setYmin(Integer y){
        displayConfig.setYmin(y);
    }

    private void setXmin(Integer x){
        displayConfig.setXmin(x);
    }

    public void setMapBounds(Integer x, Integer y){
        displayConfig.setMapBounds(x, y);
    }

    public void updateSettings(Murphy m){

        Position bound = displayConfig.getMapBounds();
        Position pos = m.getPos();
        Integer w = getWidth() / 2;
        Integer h = getHeight() / 2;
        Integer yMin = Math.max(pos.getY() - h, 0);
        Integer xMin = Math.max(pos.getX() - w, 0);

        if (yMin != 0) yMin = pos.getY() + h >= bound.getY() ? bound.getY() - getHeight() : pos.getY() - h;
        if (xMin != 0) xMin = pos.getX() + w >= bound.getX() ? bound.getX() - getWidth() : pos.getX() - w;

        setYmin(yMin);
        setXmin(xMin);
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public Position getScreenLowerBound() { return displayConfig.getMapBounds(); }

    public void increaseCurrentLevel() {
        currentLevel = currentLevel == NUM_LEVELS ? 1 : currentLevel+1;
    }

    public void lowerCurrentLevel() {
        currentLevel = currentLevel == 1 ? NUM_LEVELS : currentLevel-1;
    }

    public static void setWidth(Integer w) {
        ScreenSettings.setWidth(w);
    }

    public static void setHeight(Integer h) {
        ScreenSettings.setHeight(h);
    }

    public static void reset() {
        confs = new Configuration();
    }
}