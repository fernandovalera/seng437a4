package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.rules.ExpectedException;

/**
 * Created by Fernando on 2017-02-15.
 * Last edited by Fernando on 2017-02-16
 */
public class RangeTest_shift {
	private Range exampleRange;
	
    @Rule
    public ExpectedException exceptions = ExpectedException.none();
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-10, 10);
	}
	
	@Test
	public void test_shiftNullObject() {
		exceptions.expect(InvalidParameterException.class);
		Range.shift(null, 10);
	}
	
	@Test
	public void test_noShift() {
		Range shiftedRange = Range.shift(exampleRange, 0);
		Range expectedRange = new Range(-10, 10);
		assertEquals("Expected shift of 0 to yield shiftedRange of (-10, 10)", expectedRange, shiftedRange);
	}
	
	@Test
	public void test_shift_shiftPositiveNormal() {
		Range shiftedRange = Range.shift(exampleRange, 4);
		Range expectedRange = new Range(-6, 14);
		assertEquals("Expected shift of 4 to yield shiftedRange of (-6, 14)", expectedRange, shiftedRange);
	}
	
	@Test
	public void test_shift_shiftPositiveToZeroCrossing() {
		Range shiftedRange = Range.shift(exampleRange, 10);
		Range expectedRange = new Range(0, 20);
		assertEquals("Expected shift of 10 to yield shiftedRange of (0, 20)", expectedRange, shiftedRange);
	}
	
	@Test
	public void test_shift_shiftPositivePastZeroCrossing() {
		Range shiftedRange = Range.shift(exampleRange, 20);
		Range expectedRange = new Range(0, 30);
		assertEquals("Expected shift of 20 to yield shiftedRange of (0, 30)", expectedRange, shiftedRange);
	}
	
	@Test
	public void test_shift_shiftNegativeNormal() {
		Range shiftedRange = Range.shift(exampleRange, -4);
		Range expectedRange = new Range(-14, 6);
		assertEquals("Expected shift of -4 to yield shiftedRange of (-14, 6)", expectedRange, shiftedRange);
	}
	
	@Test
	public void test_shift_shiftNegativeToZeroCrossing() {
		Range shiftedRange = Range.shift(exampleRange, -10);
		Range expectedRange = new Range(-20, 0);
		assertEquals("Expected shift of -10 to yield shiftedRange of (-20, 0)", expectedRange, shiftedRange);
	}
	
	@Test
	public void test_shift_shiftNegativePastZeroCrossing() {
		Range shiftedRange = Range.shift(exampleRange, -20);
		Range expectedRange = new Range(-30, 0);
		assertEquals("Expected shift of -20 to yield shiftedRange of (-30, 0)", expectedRange, shiftedRange);
	}
	
	//New Test to achieve greater  Coverage
	@Test
	public void test_shift_shiftNegativePastZeroCrossingWithFalseAllowZeroCrossing() {
		Range shiftedRange = Range.shift(exampleRange, -20, false);
		Range expectedRange = new Range(-30, 0);
		assertEquals("Expected shift of -20 to yield shiftedRange of (-30, 0)", expectedRange, shiftedRange);
	}
	
	@Test
	public void test_shift_shiftNegativePastZeroCrossingWithTrueAllowZeroCrossing() {
		Range shiftedRange = Range.shift(exampleRange, -20, true);
		Range expectedRange = new Range(-30, -10);
		assertEquals("Expected shift of -20 to yield shiftedRange of (-30, 0)", expectedRange, shiftedRange);
	}
	
	@Test
	public void test_shift_shiftPastZeroCrossingWithFalseAllowZeroCrossingWithZeroBoundry() {
		Range newExampleRange = new Range(0, 5);
		Range shiftedRange = Range.shift(newExampleRange, 20, false);
		Range expectedRange = new Range(0, 25);
		assertEquals("Expected shift of -20 to yield shiftedRange of (0, 25)", expectedRange, shiftedRange);
	}
	//END New Test to achieve greater  Coverage
	
	
	@After
	public void tearDown() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}	
}
