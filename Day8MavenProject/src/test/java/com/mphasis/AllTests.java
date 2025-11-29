package com.mphasis;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalcTest.class,
    ShapeTest.class,
    CircleTest.class // new test class added here
})
public class AllTests {
    // Empty class, only used for annotations
}
