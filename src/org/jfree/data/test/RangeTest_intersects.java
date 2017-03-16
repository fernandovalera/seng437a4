package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeTest_intersects {

	Range testRange;
	@Before
    public void setUp() throws Exception {
        testRange = new Range(1.0, 5.0);
    }
	
	@Test
    public void test_intersects_noIntersectAndNotContainedWithGreaterRange(){
    	boolean actual = testRange.intersects(6.0, 99.0);
    	boolean expected = false;
    	assertEquals("does not intersect", expected, actual);
    	
    }
	
	@Test
    public void test_intersects_noIntersectAndNotContainedWithLowerRange() {
    	boolean actual = testRange.intersects(-66.0, 0.0);
    	boolean expected = false;
    	assertEquals("does not intersect", expected, actual);
    	
    }
	
	@Test
    public void test_intersects_Contained() {
    	boolean actual = testRange.intersects(3.0, 4.0);
    	boolean expected = true;
    	assertEquals("Range is contained therfore overlaps", expected, actual);
    }
	
	@Test
    public void test_intersects_intersectsRightBound() {
    	boolean actual = testRange.intersects(2.0, 99.0);
    	boolean expected = true;
    	assertEquals("Intersects", expected, actual);
    }
	
	@Test
    public void test_intersects_intersectsLeftBound() {
    	boolean actual = testRange.intersects(-2.0, 3.0);
    	boolean expected = true;
    	assertEquals("Intersects", expected, actual);
    }
	
	@Test
    public void test_intersects_InvalidRange() {
    	boolean actual = testRange.intersects(5.0, 4.0);
    	boolean expected = true;
    	assertEquals("Intersects but Invalid Range", expected, actual);
    }
	
	@Test
    public void test_intersects_equalBounds() {
    	boolean actual = testRange.intersects(1.0, 5.0);
    	boolean expected = true;
    	assertEquals("Intersects", expected, actual);
    }
}
