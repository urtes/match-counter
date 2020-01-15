package com.urte.matchcounter.counter;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CounterServiceV1Test {

    CounterService counterService = new SimpleCounterService();

    @Test
    public void testCount() {
        assertEquals(3868, counterService.countMatches(
                new BigInteger("65"),
                new BigInteger("8921")));
    }
}
