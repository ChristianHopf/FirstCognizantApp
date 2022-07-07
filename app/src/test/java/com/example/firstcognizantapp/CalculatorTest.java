package com.example.firstcognizantapp;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd(){
        int expected = 30;
        int actual = Calculator.add(10, 20);
        assertEquals(expected, actual);
        assertEquals(9, Calculator.add(4, 5));
    }

    public void testMultiply(){
        assertEquals(6, Calculator.multiply(2,3));
        assertEquals(0, Calculator.multiply(0, 69));
        assertEquals(2, Calculator.multiply(-2, -1));
    }

}