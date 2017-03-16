package org.jfree.data.test;

import static org.junit.Assert.assertEquals;

import org.jfree.data.Range;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RangeTest_constructor {
	@Rule
    public ExpectedException exceptions = ExpectedException.none();
	Range testRange;
	static double ERROR_MARGIN = 0.000000001d;
	
    @Test
    public void test_constructor_lowerBoundGreaterThanUpperBound() {
    	exceptions.expect(IllegalArgumentException.class);
    	testRange = new Range(10.1, 5.0);
    	
    }
    
    @Test
    public void test_constructor_correctParameters() {
    	double expectedUpperBound = 5.0, expectedLowerBound = 1.0;
    	testRange = new Range(expectedLowerBound, expectedUpperBound);
    	assertEquals("Expected upper bound is 5.0", expectedUpperBound, testRange.getUpperBound(), ERROR_MARGIN);
    	assertEquals("Expected lower bound is 1.0", expectedLowerBound, testRange.getLowerBound(), ERROR_MARGIN);
    	
    	
    }
    

}
