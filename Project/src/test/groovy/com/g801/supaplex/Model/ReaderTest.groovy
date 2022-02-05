package com.g801.supaplex.Model

import com.g801.supaplex.Model.Models.Sprite
import spock.lang.Specification

class ReaderTest extends Specification {

    private Sprite bitmap;

    def setup() {
        bitmap = new Sprite();
    }

    def "Fill Base Block"() {

        when:
            Reader.fillSprite("Base", bitmap);

        then:
            for (int i = 0 ; i < bitmap.getBitmap().length ; i++) {
                for (int j = 0 ; j < bitmap.getBitmap()[i].length ; j++) {
                    assert bitmap.getBitmap()[i][j] == 'B';
                }
            }
    }

    def "Fill Chip Block"() {

        when:
            Reader.fillSprite("Chip", bitmap);

        then:
            bitmap.getBitmap()[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'g'
            0 | 2 | 'G'
            1 | 2 | 'G'
            2 | 3 | 'g'
            2 | 6 | 'g'
    }

    def "Fill End Block"() {

        when:
            Reader.fillSprite("EndBlock", bitmap);

        then:
            bitmap.getBitmap()[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'O'
            0 | 2 | 'W'
            2 | 6 | 'W'
            2 | 7 | 'O'
            4 | 9 | 'O'
    }

    def "Fill Infotron Block"() {

        when:
            Reader.fillSprite("Infotron", bitmap);

        then:
            bitmap.getBitmap()[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'B'
            4 | 9 | 'A'
            2 | 0 | 'G'
            3 | 7 | 'B'
            3 | 3 | 'G'
    }

    def "Fill Murphy Block"() {

        when:
            Reader.fillSprite("Murphy", bitmap);

        then:
            bitmap.getBitmap()[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'B'
            1 | 3 | 'A'
            1 | 6 | 'A'
            3 | 4 | 'W'
            3 | 6 | 'R'
    }

    def "Fill Wall Block"() {

        when:
            Reader.fillSprite("Wall", bitmap);

        then:
            bitmap.getBitmap()[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'K'
            1 | 1 | 'C'
            2 | 5 | 'C'
            1 | 8 | 'K'
            3 | 9 | 'K'
    }

    def "Fill Rock Block"() {

        when:
            Reader.fillSprite("Rock", bitmap);

        then:
            bitmap.getBitmap()[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'B'
            1 | 1 | 'C'
            2 | 5 | 'Y'
            1 | 8 | 'C'
            3 | 9 | 'B'
    }

    def "Fill WallChip Block"() {

        when:
            Reader.fillSprite("Wall_Chip", bitmap);

        then:
            bitmap.getBitmap()[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'B'
            1 | 1 | 'C'
            2 | 5 | 'C'
            1 | 8 | 'C'
            3 | 9 | 'B'
    }
}