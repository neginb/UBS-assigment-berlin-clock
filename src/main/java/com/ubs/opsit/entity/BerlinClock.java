package com.ubs.opsit.entity;

import com.ubs.opsit.enums.Color;

import java.util.Arrays;

/**
 * This class represents a BerlinClock
 */
public class BerlinClock {
    private Row fiveHourRow;
    private Row oneHourRow;
    private Row fiveMinutesRow;
    private Row oneMinuteRow;
    private Lamp secondsLamp;

    private BerlinClock() {
        fiveHourRow = Row.Factory.getInstance(4, Color.RED);
        oneHourRow = Row.Factory.getInstance(4, Color.RED);

        fiveMinutesRow = Row.Factory.getInstance(11, Color.YELLOW);
        oneMinuteRow = Row.Factory.getInstance(4, Color.YELLOW);

        secondsLamp = Lamp.Factory.getInstance(Color.YELLOW);

        initialize();
    }

    private void initialize() {
        this.secondsLamp.switchOnLamp();
        this.fiveMinutesRow.changeColorOfLamps(Color.RED, Arrays.asList(new Integer[]{3, 6, 9}));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(secondsLamp);
        sb.append("\n");
        sb.append(fiveHourRow);
        sb.append("\n");
        sb.append(oneHourRow);
        sb.append("\n");
        sb.append(fiveMinutesRow);
        sb.append("\n");
        sb.append(oneMinuteRow);

        return sb.toString();
    }

    public Row getFiveHourRow() {
        return fiveHourRow;
    }

    public Row getOneHourRow() {
        return oneHourRow;
    }

    public Row getFiveMinutesRow() {
        return fiveMinutesRow;
    }

    public Row getOneMinuteRow() {
        return oneMinuteRow;
    }

    public Lamp getSecondsLamp() {
        return secondsLamp;
    }

    public void setFiveHourRow(Row fiveHourRow) {
        this.fiveHourRow = fiveHourRow;
    }

    public void setOneHourRow(Row oneHourRow) {
        this.oneHourRow = oneHourRow;
    }

    public void setFiveMinutesRow(Row fiveMinutesRow) {
        this.fiveMinutesRow = fiveMinutesRow;
    }

    public void setOneMinuteRow(Row oneMinuteRow) {
        this.oneMinuteRow = oneMinuteRow;
    }

    public void setSecondsLamp(Lamp secondsLamp) {
        this.secondsLamp = secondsLamp;
    }

    public static class Factory {
        public static BerlinClock getInstance() {
            return new BerlinClock();
        }
    }
}
