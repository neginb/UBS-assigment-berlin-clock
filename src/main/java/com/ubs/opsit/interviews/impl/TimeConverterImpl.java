package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.entity.BerlinClock;
import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.service.IBerlinClockService;
import com.ubs.opsit.service.impl.BerlinClockServiceImpl;

public class TimeConverterImpl implements TimeConverter {

    private IBerlinClockService berlinClockService;

    @Override
    public String convertTime(String aTime) {

        // Get service instance that will create ane update time for clock.
        berlinClockService = new BerlinClockServiceImpl(BerlinClock.Factory.getInstance());

        // Get updated time of Clock
        return berlinClockService.getConvertedTime(aTime);
    }
}
