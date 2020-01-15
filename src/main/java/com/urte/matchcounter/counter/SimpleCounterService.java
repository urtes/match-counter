package com.urte.matchcounter.counter;

import com.urte.matchcounter.App;

import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Implementation of CounterService that counts matches between one million pairs of generated numbers.
 */
public class SimpleCounterService implements CounterService {

    private static final int COMPARISONS = 1000000;

    private Function<BigInteger, BigInteger> generatorA;
    private Function<BigInteger, BigInteger> generatorB;
    private BiFunction<BigInteger, BigInteger, Boolean> matchChecker;

    public SimpleCounterService(Function<BigInteger, BigInteger> generatorA,
                                Function<BigInteger, BigInteger> generatorB,
                                BiFunction<BigInteger, BigInteger, Boolean> matchChecker) {
        this.generatorA = generatorA;
        this.generatorB = generatorB;
        this.matchChecker = matchChecker;
    }

    @Override
    public int countMatches(BigInteger argA, BigInteger argB) {

        if (argA == null || argB == null) {
            System.out.println(App.ARGUMENTS_ERROR);
            System.exit(1);
        }

        int matchCount = 0;
        BigInteger zero = new BigInteger("0");

        if (argA.equals(zero) || argB.equals(zero)) {
            System.out.println(matchCount);
            return matchCount;
        }

        BigInteger numberA = argA;
        BigInteger numberB = argB;

        for (int i = 0; i < COMPARISONS; i++) {
            numberA = generatorA.apply(numberA);
            numberB = generatorB.apply(numberB);

            if (matchChecker.apply(numberA, numberB)) {
                matchCount++;
            }
        }

        System.out.println(matchCount);
        return matchCount;
    }
}
