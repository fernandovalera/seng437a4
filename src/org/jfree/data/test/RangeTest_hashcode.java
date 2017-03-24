package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeTest_hashcode {

	@Test
    public void test_hashcode_equalObjects() {
		Range range1 = new Range(1, 5);
		Range range2 = new Range(1, 5);
		
		boolean result = range1.hashCode() == range2.hashCode();
		boolean expected = true;
		assertEquals("Hash for equal objects", expected, result);
		
    }
	
	@Test
    public void test_hashcode_unequalObjects() {
		Range range1 = new Range(2, 5);
		Range range2 = new Range(1, 5);
		
		boolean result = range1.hashCode() == range2.hashCode();
		boolean expected = false;
		assertEquals("hash for different objects", expected, result);
		
    }
	
	@Test
    public void test_hashcode_barelyUnequalObjects() {
		Range range1 = new Range(2, 5);
		Range range2 = new Range(1.999, 5);
		
		boolean result = range1.hashCode() == range2.hashCode();
		boolean expected = false;
		assertEquals("hash for objects with very similar values", expected, result);
		
    }
}
