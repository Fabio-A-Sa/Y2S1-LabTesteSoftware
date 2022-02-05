package com.g801.supaplex.Model.Elements

import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;
import spock.lang.Specification;

class InfotronTest extends Specification {

    private Infotron infotron;
    private int x = 10;
    private int y = 20;

    def setup() {
        infotron = new Infotron(new Position(x, y));
    }

    def "Infotron Position"() {
        expect:
            infotron.getPos() == new Position(x, y);
    }

    def "Infotron Size"() {

        given:
            int height = infotron.getModel().getHeight();
            int width = infotron.getModel().getWidth();

        expect:
            height == Sprite.height;
            width == Sprite.width;
    }

    def "Infotron Colors"() {

        given:
            char[][] bitmap = infotron.getModel().getBitmap();

        expect:
            bitmap[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'B'
            4 | 9 | 'A'
            2 | 0 | 'G'
            3 | 7 | 'B'
            3 | 3 | 'G'
    }
}