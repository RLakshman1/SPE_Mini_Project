package com.example;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testSqrt() {
        assertEquals(3.0, ScientificCalculator.sqrt(9.0), 1e-9);
    }

    @Test
    void testFactorial() {
        assertEquals(new BigInteger("120"), ScientificCalculator.factorial(5));
    }

    @Test
    void testLn() {
        assertEquals(1.0, ScientificCalculator.ln(Math.E), 1e-9);
    }

    @Test
    void testPower() {
        assertEquals(8.0, ScientificCalculator.power(2.0, 3.0), 1e-9);
    }
}
