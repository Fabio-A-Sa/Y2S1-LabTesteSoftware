package com.g801.supaplex.Model;

import java.util.Objects;

public class Text {
    private final String string;
    private final String backgroundColor;
    private final String foregroundColor;

    public Text(String string, String backgroundColor, String foregroundColor) {
        this.string = string;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    public String getString() {
        return string;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(string, text.string) && Objects.equals(backgroundColor, text.backgroundColor) && Objects.equals(foregroundColor, text.foregroundColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, backgroundColor, foregroundColor);
    }
}