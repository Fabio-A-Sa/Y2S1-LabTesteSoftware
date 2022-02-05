package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Models.*;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.FileNotFoundException;
import java.util.*;

public class Display {

    private static final Position blockSize = new Position(Sprite.width, Sprite.height);
    private final Configuration configurations;
    private static final List<Rock> rockList = new ArrayList<>();
    private static final List<Scissors> scissorList = new ArrayList<>();
    private static Model[][] map;
    private static Murphy murphy;
    private static Integer infotronCount = 0;


    public Display() {
        configurations = Configuration.getInstance();
        murphy = null;
        render();
    }

    public void update(Movable m, GUI.KEYACTION keyaction){

        Position oldPosition = new Position(m.getPos().getX(), m.getPos().getY());

        switch (keyaction) {
            case DOWN -> oldPosition.addY(-1);
            case UP -> oldPosition.addY(1);
            case LEFT -> oldPosition.addX(1);
            case RIGHT -> oldPosition.addX(-1);
        }

        map[oldPosition.getY()][oldPosition.getX()] = new Base(oldPosition);
        map[m.getPos().getY()][m.getPos().getX()] = m;
    }

    public void updateRock(Model m) {
        int x = m.getPos().getX(), y = m.getPos().getY();
        map[y][x] = m;
        map[y-1][x] = new Base(new Position(x, y));
    }

    public void updateRockRight(Model m) {
        int xLeft = m.getPos().getX(), yLeft = m.getPos().getY();
        map[yLeft][xLeft] = m;
        map[yLeft-1][xLeft-1] = new Base(new Position(yLeft-1, xLeft-1));
    }

    public void updateRockLeft(Model m) {
        int xRight = m.getPos().getX(), yRight = m.getPos().getY();
        map[yRight][xRight] = m;
        map[yRight-1][xRight+1] = new Base(new Position(yRight-1, xRight+1));
    }

    public void updateScissor(Scissors m) {

        Position oldPosition = new Position(m.getPos().getX(), m.getPos().getY());
        map[m.getPos().getY()][m.getPos().getX()] = m;

        switch (m.getDirection()) {
            case RIGHT -> oldPosition.addX(-1);
            case LEFT -> oldPosition.addX(1);
            case DOWN -> oldPosition.addY(-1);
            case UP -> oldPosition.addY(1);
        }

        map[oldPosition.getY()][oldPosition.getX()] = new Base(oldPosition);
    }

    public void render() {

        endGame();
        LoadLevelBuild level = null;
        try {
            level = new LoadLevelBuild(configurations.getCurrentLevel());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert level != null;

        ArrayList<String> gameMap = level.getLevelMap();
        Position bounds = configurations.getMapBounds(), modelPos;
        map = new Model[bounds.getY()][bounds.getX()];

        for (int i = 0; i < gameMap.size(); i++) {
            String line = gameMap.get(i);
            for (int j = 0; j < line.length(); j++) {
                Model load = new Model();
                modelPos = new Position(j, i);
                switch (line.charAt(j)) {
                    case ' ' -> load = new Base(modelPos);
                    case 'W' -> load = new Wall(modelPos);
                    case 'C' -> load = new Chip(modelPos);
                    case 'E' -> load = new EndBlock(modelPos);
                    case 'K' -> {
                        load = new Wall(modelPos);
                        load.setSprite('K');
                    }
                    case 'R' -> {
                        load = new Rock(modelPos);
                        rockList.add((Rock) load);
                    }
                    case 'X' -> {
                        load = new Scissors(modelPos);
                        scissorList.add((Scissors) load);
                    }
                    case 'M' -> {
                        load = new Murphy(modelPos);
                        murphy = (Murphy) load;
                        updateTopLeft();
                        }
                    case 'I' -> {
                        load = new Infotron(modelPos);
                        infotronCount++;
                    }
                }
                map[i][j] = load;
            }
        }
        configurations.updateSettings(murphy);
    }

    public Model[][] getDisplayMap () {

        Integer x = configurations.getWidth();
        Integer y = configurations.getHeight();
        Integer yMin = configurations.getYmin();
        Integer xMin = configurations.getXmin();
        Model[][] ret = new Model[y][x];

        for (int i = 0; i < y; i++) {
            System.arraycopy(map[yMin + i], xMin, ret[i], 0, x);
        }
        return ret;
    }

    public Integer getInfotronCount () {
        return infotronCount;
    }

    public void decrementInfotronCount() {
        infotronCount--;
    }

    public void updateTopLeft () {
        configurations.updateSettings(getMurphy());
    }

    public Position getBlockSize() {
        return blockSize;
    }

    public Murphy getMurphy() {
        return murphy;
    }

    public void endGame() {
        map = null;
        murphy = null;
        scissorList.clear();
        rockList.clear();
        infotronCount = 0;
    }

    public Model[][] getMap() {
        return map;
    }

    public List<Rock> getRockList() {
        return rockList;
    }

    public List<Scissors> getScissorList() {
        return scissorList;
    }
}