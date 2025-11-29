package com.mphasis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalcTest {

	 @Test
	    public void add() {
	    	int expected = 10;
	    	int actual = new Calculator().add(2,3);
	    	assertEquals(expected, actual);
	    }
	
}
