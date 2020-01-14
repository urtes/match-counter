package com.urte.matchcounter.comparator;

import java.math.BigInteger;

public class ComparatorServiceBy8LastBits implements ComparatorService {

    private static final int comparisonLength = 8;

    @Override
    public boolean isMatch(BigInteger numberA, BigInteger numberB) {

        String a = numberA.toString(2);
        String b = numberB.toString(2);

        // It is accepted, that if either of the resulting binary strings is shorter than comparisonLength (8),
        // strings cannot be compared and result is false.
        try {
            return b.endsWith(a.substring(a.length() - comparisonLength));
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }
}
