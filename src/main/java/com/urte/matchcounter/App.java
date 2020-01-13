package com.urte.matchcounter;

import java.math.BigInteger;

/**
 * Responsible for user input reception and validation. If the input is valid, passes it for further processing.
 */
public class App {

    private final static String ARGUMENTS_ERROR = "Please enter two numbers";

    public static void main( String[] args )
    {
        if (args.length != 2) {
            exit(ARGUMENTS_ERROR);
        }

        BigInteger argA = new BigInteger("0");
        BigInteger argB = new BigInteger("0");

        try {
            argA = new BigInteger(args[0]);
            argB = new BigInteger(args[1]);
        } catch (NumberFormatException exception) {
            exit(ARGUMENTS_ERROR);
        }

        System.out.println(String.format("input one: %d\ninput two: %d", argA, argB));
    }

    private static void exit(String errorMessage) {
        System.out.println(errorMessage);
        System.exit(1);
    }
}