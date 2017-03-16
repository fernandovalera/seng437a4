package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeTest_equals {
	Range testRange;
	@Before
    public void setUp() throws Exception {
        testRange = new Range(1.0, 5.0);
    }
	
	@Test
    public void test_equals_unequalUpperBound() {
        Range otherRange = new Range(1.0, 6.0);
        boolean actual = testRange.equals(otherRange);
        assertEquals(false, actual);
    }
	
	@Test
    public void test_equals_unequalLowerBound() {
        Range otherRange = new Range(2.0, 5.0);
        boolean actual = testRange.equals(otherRange);
        assertEquals(false, actual);
    }
	
	@Test
    public void test_equals_equalBound() {
        Range otherRange = new Range(1.0, 5.0);
        boolean actual = testRange.equals(otherRange);
        assertEquals(true, actual);
    }
	
	@Test
    public void test_equals_nullRange() {
        Range otherRange = null;
        boolean actual = testRange.equals(otherRange);
        assertEquals(false, actual);
    }
	
	
}
