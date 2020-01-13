package com.urte.matchcounter.generator;

import java.math.BigInteger;

public class GeneratorServiceCoefficient16807 implements GeneratorService {

    private static BigInteger multiplier = new BigInteger("16807");
    private static BigInteger divider = new BigInteger("2147483647");

    @Override
    public BigInteger generate(BigInteger number) {
        return number.multiply(multiplier).mod(divider);
    }
}
