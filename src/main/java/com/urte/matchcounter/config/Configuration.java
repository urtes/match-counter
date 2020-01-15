package com.urte.matchcounter.config;

import com.urte.matchcounter.counter.CounterService;
import com.urte.matchcounter.counter.SimpleCounterService;

import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Class that is responsible for configuring CounterService:
 * 1) Injects CounterService with two generators that generate numbers from user input by the following formula:
 *    number = input * multiplier % divider;
 * 2) Injects CounterService with match checker
 *    that takes two numbers and checks if eight last bits of their binary presentations match;
 */
public class Configuration {

    private static final int MATCH_SUBSTRING_LENGTH = 8;
    private static final BigInteger DIVIDER = new BigInteger("2147483647");
    private static final BigInteger MULTIPLIER_A = new BigInteger("16807");
    private static final BigInteger MULTIPLIER_B = new BigInteger("48271");

    public CounterService getCounterService() {
        Function<BigInteger, BigInteger> generatorA = (BigInteger number) ->
                generate(number, MULTIPLIER_A);

        Function<BigInteger, BigInteger> generatorB = (BigInteger number) ->
                generate(number, MULTIPLIER_B);

        BiFunction<BigInteger, BigInteger, Boolean> matchChecker = (BigInteger numberA, BigInteger numberB) -> {
            String a = numberA.toString(2);
            String b = numberB.toString(2);

            // It is accepted, that if either of the binary strings is shorter than COMPARISON_LENGTH (8),
            // strings cannot be compared and the result is false.
            try {
                return b.endsWith(a.substring(a.length() - MATCH_SUBSTRING_LENGTH));
            } catch (StringIndexOutOfBoundsException e) {
                return false;
            }
        };

        return new SimpleCounterService(generatorA, generatorB, matchChecker);
    }

    private BigInteger generate(BigInteger number, BigInteger multiplier) {
        return number.multiply(multiplier).mod(DIVIDER);
    }
}
