package com.ubs.opsit.entity;

import com.ubs.opsit.enums.Color;

/**
 * This class represents a lamp on the clock.
 */
public class Lamp {

    private Color lampColor;
    private boolean switchedOn;

    private Lamp(Color color) {
        this.lampColor = color;
        this.switchedOn = false;
    }

    @Override
    public String toString() {
        if (this.switchedOn) {
            return this.lampColor.toString();
        } else {
            return "O";
        }
    }

    public  void switchOnLamp(){
        this.switchedOn = true;
    }

    public void switchOffLamp(){
        this.switchedOn = false;
    }

    public Color getLampColor() {
        return lampColor;
    }

    public void setLampColor(Color lampColor) {
        this.lampColor = lampColor;
    }

    public boolean isSwitchedOn() {
        return switchedOn;
    }

    public void setSwitchedOn(boolean switchedOn) {
        this.switchedOn = switchedOn;
    }

    public static class Factory {
        public static Lamp getInstance(Color color){
            return new Lamp(color);
        }
    }
}
