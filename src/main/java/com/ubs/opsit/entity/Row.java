package com.ubs.opsit.entity;

import com.ubs.opsit.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class represents a row of the clock and contains the lamps.
 */
public class Row {

    private List<Lamp> lamps;

    private Row(int noOfLamps, Color color) {
        this.lamps = new ArrayList<>(noOfLamps);

        this.lamps = IntStream.range(0, noOfLamps).mapToObj(i -> Lamp.Factory.getInstance(color)).collect(Collectors.toList());
    }

    /**
     * Switches on the lampNos lamps from starting point of the row.
     *
     * @param lampNos
     */
    public void switchOnAllLampsFromLeft(int lampNos) {
        if (lampNos >= 0 && lampNos <= this.lamps.size()) {
            for (int i = 0; i < lampNos; i++) {
                if (i < lampNos) {
                    this.lamps.get(i).switchOnLamp();
                } else {
                    this.lamps.get(i).switchOffLamp();
                }
            }
        }
    }

    public void changeColorOfLamps(Color color, List<Integer> lampNos) {

        for (int lampNo : lampNos) {
            if (lampNo > 0 && lampNo < this.lamps.size()) {
                this.lamps.get(lampNo - 1).setLampColor(color);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        this.lamps.forEach(i -> sb.append(i.toString()));

        return sb.toString();
    }

    public static  class Factory {
        public static Row getInstance(int noOfLamps, Color color){
            return new Row(noOfLamps, color);
        }
    }

}
