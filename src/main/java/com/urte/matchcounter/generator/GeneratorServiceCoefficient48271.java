package com.urte.matchcounter.generator;

import java.math.BigInteger;

public class GeneratorServiceCoefficient48271 implements GeneratorService {

    private static BigInteger multiplier = new BigInteger("48271");
    private static BigInteger divider = new BigInteger("2147483647");

    @Override
    public BigInteger generate(BigInteger number) {
        return number.multiply(multiplier).mod(divider);
    }
}
