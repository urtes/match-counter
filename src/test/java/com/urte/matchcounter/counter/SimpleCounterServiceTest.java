package com.urte.matchcounter.counter;

import com.urte.matchcounter.config.Configuration;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class SimpleCounterServiceTest {

    Configuration configuration = new Configuration();
    CounterService counterService = configuration.getCounterService();

    @Test
    public void testCount() {
        assertEquals(3868, counterService.countMatches(
                new BigInteger("65"),
                new BigInteger("8921")));
    }
}
