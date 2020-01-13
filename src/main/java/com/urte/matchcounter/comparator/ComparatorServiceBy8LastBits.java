package com.urte.matchcounter.comparator;

import java.math.BigInteger;

public class ComparatorServiceBy8LastBits implements ComparatorService {

    private static final int comparisonLength = 8;

    @Override
    public boolean isMatch(BigInteger numberA, BigInteger numberB) {

        String a = numberA.toString(2);
        String b = numberB.toString(2);
        int aLength = a.length();
        int bLength = b.length();

        if (aLength <= comparisonLength && bLength <= comparisonLength) {
            return a.equals(b);
        } else if (aLength > comparisonLength && bLength > comparisonLength) {
            return b.endsWith(a.substring(a.length() - comparisonLength));
        } else  if (aLength > comparisonLength) {
            if (endingFits(a, b)) {
                return restAreZeroes(a, b.length());
            }
            return false;
        } else {
            if (endingFits(b, a)) {
                return restAreZeroes(b, a.length());
            }
            return false;
        }
    }

    private boolean endingFits(String longer, String shorter) {
        return longer.endsWith(shorter);
    }

    private boolean restAreZeroes (String stringToCheck, int endingIndex) {
        String substringToCheck = stringToCheck.substring(stringToCheck.length() - comparisonLength, endingIndex);
        return Integer.parseInt(substringToCheck) == 0;
    }
}
