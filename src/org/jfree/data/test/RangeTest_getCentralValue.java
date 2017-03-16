package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeTest_getCentralValue {
	static double ERROR_MARGIN = 0.000000001d;
	Range testRange;
	
    @Test
    public void test_getCentralValue_withPositiveValues() {
    	testRange = new Range(1.0, 3.0);
    	double actual = testRange.getCentralValue();
    	double expected = 2.0;
    	assertEquals("Central Value hould be 2.0" ,expected, actual, ERROR_MARGIN);
    }
    @Test
    public void test_getCentralValue_withPositiveAndNegativeValues() {
    	testRange = new Range(-3.0, 3.0);
    	double actual = testRange.getCentralValue();
    	double expected = 0.0;
    	assertEquals("Central Value hould be 0.0" ,expected, actual, ERROR_MARGIN);
    }
    @Test
    public void test_getCentralValue_withNegativeValues() {
    	testRange = new Range(-3.0, -1.0);
    	double actual = testRange.getCentralValue();
    	double expected = -2.0;
    	assertEquals("Central Value hould be -2.0" ,expected, actual, ERROR_MARGIN);
    }

}
