package com.ubs.opsit.service;

import com.sun.jndi.ldap.Ber;
import com.ubs.opsit.entity.BerlinClock;
import com.ubs.opsit.service.impl.BerlinClockServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BerlinClockServiceImplTest {

    IBerlinClockService berlinClockService;

    @Before
    public void setUp(){
        berlinClockService = new BerlinClockServiceImpl(BerlinClock.Factory.getInstance());
    }

    @Test
    public  void testFiveHoursRow(){
        String result = berlinClockService.getConvertedTime("15:00:00");

        StringBuilder sb = new StringBuilder();
        sb.append("Y");
        sb.append("\n");
        sb.append("RRRO");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("OOOOOOOOOOO");
        sb.append("\n");
        sb.append("OOOO");

        assertEquals(sb.toString(), result);
    }

    @Test
    public  void testOneHoursRow(){
        String result = berlinClockService.getConvertedTime("2:00:00");

        StringBuilder sb = new StringBuilder();
        sb.append("Y");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("RROO");
        sb.append("\n");
        sb.append("OOOOOOOOOOO");
        sb.append("\n");
        sb.append("OOOO");

        assertEquals(sb.toString(), result);
    }

    @Test
    public  void testFiveMinutesRow(){
        String result = berlinClockService.getConvertedTime("00:20:00");

        StringBuilder sb = new StringBuilder();
        sb.append("Y");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("YYRYOOOOOOO");
        sb.append("\n");
        sb.append("OOOO");

        assertEquals(sb.toString(), result);
    }

    @Test
    public  void testOneMinuteRow(){
        String result = berlinClockService.getConvertedTime("00:02:00");

        StringBuilder sb = new StringBuilder();
        sb.append("Y");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("OOOOOOOOOOO");
        sb.append("\n");
        sb.append("YYOO");

        assertEquals(sb.toString(), result);
    }

    @Test
    public  void testEvenSeconds(){
        String result = berlinClockService.getConvertedTime("00:00:02");

        StringBuilder sb = new StringBuilder();
        sb.append("Y");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("OOOOOOOOOOO");
        sb.append("\n");
        sb.append("OOOO");

        assertEquals(sb.toString(), result);
    }

    @Test
    public  void testOddSeconds(){
        String result = berlinClockService.getConvertedTime("00:00:01");

        StringBuilder sb = new StringBuilder();
        sb.append("O");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("OOOO");
        sb.append("\n");
        sb.append("OOOOOOOOOOO");
        sb.append("\n");
        sb.append("OOOO");

        assertEquals(sb.toString(), result);
    }

}