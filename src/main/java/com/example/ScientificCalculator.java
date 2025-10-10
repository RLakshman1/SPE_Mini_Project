package com.example;

import java.math.BigInteger;

public class ScientificCalculator {

    public static double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("Square root of negative number");
        return Math.sqrt(x);
    }

    public static BigInteger factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial of negative number");
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static double ln(double x) {
        if (x <= 0) throw new IllegalArgumentException("Natural log of non-positive number");
        return Math.log(x);
    }

    public static double power(double x, double b) {
        return Math.pow(x, b);
    }
}
