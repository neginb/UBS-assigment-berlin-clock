package com.ubs.opsit.service.impl;

import com.ubs.opsit.entity.BerlinClock;
import com.ubs.opsit.service.IBerlinClockService;

public class BerlinClockServiceImpl implements IBerlinClockService{

    private BerlinClock berlinClock;

    public BerlinClockServiceImpl(BerlinClock berlinClock) {
        this.berlinClock = berlinClock;
    }

    private void updateSeconds(int seconds) {
        if (seconds % 2 == 0) {
            berlinClock.getSecondsLamp().switchOnLamp();
        } else {
            berlinClock.getSecondsLamp().switchOffLamp();
        }
    }

    private void updateMinutes(int minutes) {
        int fiveMinutes = minutes / 5;
        int remaining = minutes % 5;

        berlinClock.getFiveMinutesRow().switchOnAllLampsFromLeft(fiveMinutes);
        berlinClock.getOneMinuteRow().switchOnAllLampsFromLeft(remaining);

    }

    private void updateHours(int hours) {
        int fiveHrs = hours / 5;
        int remaining = hours % 5;

        berlinClock.getFiveHourRow().switchOnAllLampsFromLeft(fiveHrs);
        berlinClock.getOneHourRow().switchOnAllLampsFromLeft(remaining);
    }

    @Override
    public String getConvertedTime(String aTime) {
        String[] tokens = aTime.split(":");
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);

        updateHours(hours);
        updateMinutes(minutes);
        updateSeconds(seconds);

        return berlinClock.toString();
    }
}
