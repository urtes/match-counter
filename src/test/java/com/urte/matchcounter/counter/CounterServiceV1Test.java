package com.urte.matchcounter.counter;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CounterServiceV1Test {

    CounterService counterService = new CounterServiceV1();

    @Test
    public void testCount() {
        assertEquals(3868, counterService.count(
                new BigInteger("65"),
                new BigInteger("8921")));
    }
}
