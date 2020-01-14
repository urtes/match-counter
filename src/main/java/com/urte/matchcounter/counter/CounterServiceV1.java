package com.urte.matchcounter.counter;

import com.urte.matchcounter.comparator.ComparatorService;
import com.urte.matchcounter.generator.GeneratorService;

import java.math.BigInteger;

public class CounterServiceV1 implements CounterService {

    private static final int COMPARISONS = 1000000;
    private static final int COMPARISON_LENGTH = 8;
    private static final BigInteger DIVIDER = new BigInteger("2147483647");
    private static final BigInteger MULTIPLIER_A = new BigInteger("16807");
    private static final BigInteger MULTIPLIER_B = new BigInteger("48271");


    private GeneratorService generatorServiceA = (BigInteger number) ->
            generate(number, MULTIPLIER_A);

    private GeneratorService generatorServiceB = (BigInteger number) ->
            generate(number, MULTIPLIER_B);

    private ComparatorService comparatorService =(BigInteger numberA, BigInteger numberB) -> {
        String a = numberA.toString(2);
        String b = numberB.toString(2);

        // It is accepted, that if either of the binary strings is shorter than COMPARISON_LENGTH (8),
        // strings cannot be compared and the result is false.
        try {
            return b.endsWith(a.substring(a.length() - COMPARISON_LENGTH));
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    };

    @Override
    public int count(BigInteger argA, BigInteger argB) {

        int matchCount = 0;
        BigInteger numberA = argA;
        BigInteger numberB = argB;

        for (int i = 0; i < COMPARISONS; i++) {
            numberA = generatorServiceA.generate(numberA);
            numberB = generatorServiceB.generate(numberB);

            if (comparatorService.isMatch(numberA, numberB)) {
                matchCount++;
            }
        }

        System.out.println(matchCount);
        return matchCount;
    }

    private BigInteger generate(BigInteger number, BigInteger multiplier) {
        return number.multiply(multiplier).mod(DIVIDER);
    }
}