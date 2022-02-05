package com.g801.supaplex.Controller.Display

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Elements.Base
import com.g801.supaplex.Model.Elements.Chip
import com.g801.supaplex.Model.Elements.Infotron;
import com.g801.supaplex.Model.Elements.Wall
import com.g801.supaplex.Model.Level.Display
import com.g801.supaplex.Model.Models.Model
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Viewer.GUI.GUI;
import spock.lang.Specification;

class MurphyControllerTest extends Specification {

    private Game game;
    private Display display;
    private long time;
    private Murphy murphy;
    private MurphyController murphyController;
    private Model[][] fakeMapWithBase;
    private Model[][] fakeMapWithInfotrons;
    private Model[][] fakeMapWithWall;
    private Model[][] fakeMapWithChip;

    def setup() {

        game = Mock(Game.class);
        display = Mock(Display.class);
        murphy = Mock(Murphy.class);
        murphy.getPos() >> new Position(1, 1);

        fakeMapWithBase = new Model[3][3];
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                fakeMapWithBase[i][j] = new Base(new Position(i, j));
            }
        }

        fakeMapWithInfotrons = new Model[3][3];
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                fakeMapWithInfotrons[i][j] = new Infotron(new Position(i, j));
            }
        }

        fakeMapWithWall = new Model[3][3];
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                fakeMapWithWall[i][j] = new Wall(new Position(i, j));
            }
        }

        fakeMapWithChip = new Model[3][3];
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                fakeMapWithChip[i][j] = new Chip(new Position(i, j));
            }
        }

        display.getMurphy() >> murphy;
        murphyController = new MurphyController(display);
    }

    def "Murphy moves Down"() {

        given:
            display.getMap() >> fakeMapWithBase;
        when:
            murphyController.execute(game, GUI.KEYACTION.DOWN, time);
        then:
            1 * murphy.moveDown();
            1 * display.update(murphy, GUI.KEYACTION.DOWN);
    }

    def "Murphy moves Up"() {

        given:
            display.getMap() >> fakeMapWithBase;
        when:
            murphyController.execute(game, GUI.KEYACTION.UP, time);
        then:
            1 * murphy.moveUp();
            1 * display.update(murphy, GUI.KEYACTION.UP);
    }

    def "Murphy moves Left"() {

        given:
            display.getMap() >> fakeMapWithBase;
        when:
            murphyController.execute(game, GUI.KEYACTION.LEFT, time);
        then:
            1 * murphy.moveLeft();
            1 * display.update(murphy, GUI.KEYACTION.LEFT);
    }

    def "Murphy moves Right"() {

        given:
            display.getMap() >> fakeMapWithBase;
        when:
            murphyController.execute(game, GUI.KEYACTION.RIGHT, time);
        then:
            1 * murphy.moveRight();
            1 * display.update(murphy, GUI.KEYACTION.RIGHT);
    }

    def "Murphy eats Right"() {

        given:
            display.getMap() >> fakeMapWithChip;
            assert fakeMapWithChip[1][2] instanceof Chip;
        when:
            murphyController.execute(game, GUI.KEYACTION.EAT_RIGHT, time);
        then:
            fakeMapWithChip[1][2] instanceof Base;
    }

    def "Murphy eats Left"() {

        given:
            display.getMap() >> fakeMapWithChip;
            assert fakeMapWithChip[1][0] instanceof Chip;
        when:
            murphyController.execute(game, GUI.KEYACTION.EAT_LEFT, time);
        then:
            fakeMapWithChip[1][0] instanceof Base;
    }

    def "Murphy eats Up"() {

        given:
            display.getMap() >> fakeMapWithChip;
            assert fakeMapWithChip[0][1] instanceof Chip;
        when:
            murphyController.execute(game, GUI.KEYACTION.EAT_UP, time);
        then:
            fakeMapWithChip[0][1] instanceof Base;
    }

    def "Murphy eats Down"() {

        given:
            display.getMap() >> fakeMapWithChip;
            assert fakeMapWithChip[2][1] instanceof Chip;
        when:
            murphyController.execute(game, GUI.KEYACTION.EAT_DOWN, time);
        then:
            fakeMapWithChip[2][1] instanceof Base;
    }

    def "Murphy doesn't move!"() {

        given:
            display.getMap() >> fakeMapWithWall;

        when:
            murphyController.execute(game, GUI.KEYACTION.UP, time);
        then:
            0 * murphy.moveUp;

        when:
            murphyController.execute(game, GUI.KEYACTION.DOWN, time);
        then:
            0 * murphy.moveDown();

        when:
            murphyController.execute(game, GUI.KEYACTION.LEFT, time);
        then:
            0 * murphy.moveLeft();

        when:
            murphyController.execute(game, GUI.KEYACTION.RIGHT, time);
        then:
            0 * murphy.moveRight();
    }

    def "Let's eat some Infotrons!"() {

        given:
            display.getMap() >> fakeMapWithInfotrons;

        when:
            murphyController.execute(game, GUI.KEYACTION.RIGHT, time)
            murphyController.execute(game, GUI.KEYACTION.DOWN, time)
            murphyController.execute(game, GUI.KEYACTION.LEFT, time)
            murphyController.execute(game, GUI.KEYACTION.LEFT, time)
            murphyController.execute(game, GUI.KEYACTION.UP, time)
            murphyController.execute(game, GUI.KEYACTION.UP, time)
            murphyController.execute(game, GUI.KEYACTION.RIGHT, time)
            murphyController.execute(game, GUI.KEYACTION.RIGHT, time)
            murphyController.execute(game, GUI.KEYACTION.LEFT, time)

        then:
            9 * display.decrementInfotronCount();
    }
}