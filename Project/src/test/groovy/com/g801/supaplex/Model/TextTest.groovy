package com.g801.supaplex.Model

import spock.lang.Specification;

class TextTest extends Specification {

    private Text textA;

    def setup() {
        textA = new Text("testing", "#AAAFFF", "#0F0F0F");
    }

    def "Initial text configuration"() {

        expect:
            textA.getString() == "testing";
            textA.getBackgroundColor() == "#AAAFFF";
            textA.getForegroundColor() == "#0F0F0F";
    }

    def "Text A != Text B"() {

        given:
            Text textB = new Text("LTDS", "#AAAFFF", "#0F0F0F");
        expect:
            !textA.equals(textB);
            textA.hashCode() != textB.hashCode();
    }
}