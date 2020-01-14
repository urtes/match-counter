package com.urte.matchcounter.comparator;

import java.math.BigInteger;

/**
 * Service that is responsible for comparing a pair of numbers.
 */
public interface ComparatorService {

    boolean isMatch(BigInteger numberA, BigInteger numberB);
}
