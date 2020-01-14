package com.urte.matchcounter.counter;

import java.math.BigInteger;

/**
 * Service that is responsible for counting matches between pairs of numbers.
 */
public interface CounterService {

    int countMatches(BigInteger argA, BigInteger argB);
}
