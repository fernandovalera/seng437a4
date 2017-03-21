package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeTest_expandToInclude {
	Range testRange;
	@Before
    public void setUp() throws Exception {
        testRange = new Range(1.0, 5.0);
    }
	
    @Test
    public void test_expandToInclude_positiveNumber() {
    	Range result = Range.expandToInclude(testRange, 20.0);
    	assertTrue("New Range contains 20.0", result.getUpperBound() >= 20.0);
    	assertTrue("New Range contains previous Range", result.getLowerBound() <= 1.0);
    }
    
    @Test
    public void test_expandToInclude_negativeNumber() {
    	Range result = Range.expandToInclude(testRange, -20.0);
    	assertTrue("New Range contains -20.0", result.getLowerBound() <= -20.0);
    	assertTrue("New Range contains previous Range", result.getUpperBound() >= 5.0);
    }
    
    @Test
    public void test_expandToInclude_alreadyInRange() {
    	Range result = Range.expandToInclude(testRange, 4.0);
    	assertTrue("New Range contains previous Range", result.getUpperBound() >= 5.0);
    	assertTrue("New Range contains previous Range", result.getLowerBound() <= 1.0);
    }
   
    @Test
    public void test_expandToInclude_nullRange() {
    	Range result = Range.expandToInclude(null, 4.0);
    	assertTrue("New Range contains previous Range", result.getUpperBound() >= 4.0);
    	assertTrue("New Range contains previous Range", result.getLowerBound() <= 4.0);
    }
    

}
