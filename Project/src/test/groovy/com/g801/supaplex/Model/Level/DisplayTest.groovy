package com.g801.supaplex.Model.Level

import com.g801.supaplex.Model.Configuration
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Models.Model
import com.g801.supaplex.Model.Position
import spock.lang.Specification;

class DisplayTest extends Specification {

    private Display display;
    private Position position;
    private Murphy murphy;

    def setup() {
        Configuration config = Mock(Configuration.class);
        config.getCurrentLevel() >> 1;
        position = new Position(10, 10);
        murphy = new Murphy(position);
        display = new Display();
        List<Model> answer = new ArrayList<Model>()
        for (int i = 0 ; i < 4 ; i++) answer.push(new Model());
    }

    def cleanup() {
        Configuration.reset();
    }

    def "Getting Display Map"() {

        when:
            Configuration configuration = Configuration.getInstance();
            Model[][] map = display.getDisplayMap();

        then:
            map[0].length == configuration.getWidth();
            map.length == configuration.getHeight();
    }

    def "Getting Infotron Counter"() {

        expect:
            display.getInfotronCount() == 19;
    }

    def "Block Size"() {

        expect:
            display.getBlockSize() == new Position(10, 5);
    }

    def "Some configurations"() {

        expect:
            display.getMap() != null;
            display.getScissorList() != null;
            display.getRockList() != null;
    }

}