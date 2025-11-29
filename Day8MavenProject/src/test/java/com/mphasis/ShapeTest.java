package com.mphasis;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ShapeTest  {

	@ParameterizedTest
	@ValueSource(strings = {"com.mphasis.Triangle"})
	public void drawTest(String className) throws Exception {
	    Class<?> clazz = Class.forName(className);
	    Shape shape = (Shape) clazz.getDeclaredConstructor().newInstance();

	    shape.draw(); // should print something
	    assertNotNull(shape); // basic assertion
	}

    }

