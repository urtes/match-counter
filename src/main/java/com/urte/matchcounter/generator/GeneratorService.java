package com.urte.matchcounter.generator;

import java.math.BigInteger;

/**
 * Service that is responsible for generating numbers.
 */
public interface GeneratorService {

    BigInteger generate(BigInteger number);
}
