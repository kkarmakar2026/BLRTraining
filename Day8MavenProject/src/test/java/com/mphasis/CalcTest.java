package com.mphasis;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class  CalcTest {

    @Test
    public void add() {
        int expected = 5;
        int actual = new Calculator().add(2, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void sub() {
        int expected = 60;
        int actual = new Calculator().sub(110, 50);
        assertEquals(expected, actual);
    }

    @Test
    public void mul() {
        int expected = 6;
        int actual = new Calculator().mul(2, 3);
        assertEquals(expected, actual);
    }

    @Test
    public  void div() {
        int expected = 5;
        int actual = new Calculator().div(10, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void isEvenTest() {
        assertTrue(new Calculator().isEven(4), "for input 4 result must be true");
    }

    @Test
    public void checkArraysTest() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = new Calculator().checkArrays();
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void checkAETest() {
        assertTrue(new Calculator().checkAE() instanceof ArithmeticException);
    }
    
    @BeforeAll
    public static void beforeEveryTest() {
    	System.out.println("Testing of api started");
    }
    
    @BeforeEach
    public void afterEach() {
    	System.out.println("Testing of api started");
    }

}
