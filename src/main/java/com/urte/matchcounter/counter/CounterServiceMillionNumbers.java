package com.urte.matchcounter.counter;

import com.urte.matchcounter.comparator.ComparatorService;
import com.urte.matchcounter.comparator.ComparatorServiceBy8LastBits;
import com.urte.matchcounter.generator.GeneratorService;
import com.urte.matchcounter.generator.GeneratorServiceCoefficient16807;
import com.urte.matchcounter.generator.GeneratorServiceCoefficient48271;

import java.math.BigInteger;

public class CounterServiceMillionNumbers implements CounterService {

    private static final int comparisons = 1000000;
    private GeneratorService generatorServiceA = new GeneratorServiceCoefficient16807();
    private GeneratorService generatorServiceB = new GeneratorServiceCoefficient48271();
    private ComparatorService comparatorService = new ComparatorServiceBy8LastBits();

    @Override
    public int count(BigInteger argA, BigInteger argB) {

        int matchCount = 0;
        BigInteger numberA = argA;
        BigInteger numberB = argB;

        for (int i = 0; i < comparisons; i++) {
            numberA = generatorServiceA.generate(numberA);
            numberB = generatorServiceB.generate(numberB);

            if (comparatorService.isMatch(numberA, numberB)) {
                matchCount++;
            }

        }

        System.out.println(matchCount);
        return matchCount;
    }
}
