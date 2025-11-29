package com.mphasis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CircleTest {

    @Test
    public void drawTest() {
        Circle circle = new Circle();
        circle.draw();
        assertNotNull(circle); // ensure object is created
    }

    @Test
    public void areaTest() {
        Circle circle = new Circle();
        double expected = Math.PI * 2 * 2; // radius = 2
        double actual = circle.area(2);
        assertEquals(expected, actual, 0.0001); // allow small delta
    }
}
