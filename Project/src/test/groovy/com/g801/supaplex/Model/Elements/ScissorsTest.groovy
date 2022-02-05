package com.g801.supaplex.Model.Elements

import com.g801.supaplex.Model.Models.Sprite
import com.g801.supaplex.Model.Position
import spock.lang.Specification

class ScissorsTest extends Specification {

    private Scissors s;
    private int x = 10;
    private int y = 20;

    def setup() {
        s = new Scissors(new Position(x, y));
    }

    def "Scissors Position"() {
        expect:
        s.getPos() == new Position(x, y);
    }

    def "Scissors Size"() {

        given:
        int height = s.getModel().getHeight();
        int width = s.getModel().getWidth();

        expect:
        height == Sprite.height;
        width == Sprite.width;
    }

    def "Scissors Colors"() {

        given:
        char[][] bitmap = s.getModel().getBitmap();

        expect:
        bitmap[a][b] == c;

        where:
        a | b | c
        0 | 0 | 'B'
        0 | 2 | 'Y'
        2 | 6 | 'B'
        2 | 7 | 'B'
        4 | 9 | 'R'
    }

    def "Scissors direction"() {

        given:
        s.setDirection(Scissors.Direction.UP);
        expect:
        s.getDirection() == Scissors.Direction.UP;
    }
}