package com.ubs.opsit.enums;

/**
 * Enum to define the state represented by color of each lamp.
 */
public enum Color {

    RED("R"),
    YELLOW("Y");

    private String lampColor;

    Color(String color) {
        this.lampColor = color;
    }

    @Override
    public String toString() {
        return this.lampColor;
    }
}
