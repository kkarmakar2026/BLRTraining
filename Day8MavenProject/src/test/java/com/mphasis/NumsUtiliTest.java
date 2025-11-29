package com.mphasis;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumsUtiliTest {

	@ParameterizedTest
	@ValueSource(ints= {2,6,4})
	public void isEvenTest(int n) {
		assertTrue(NumsUtili.isEven(n));
	}
}
