package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * Edited by Fernando on 2017-02-15.
 */
public class DataUtilitiesTest_createNumberArray {
	
    @Rule
    public ExpectedException exceptions = ExpectedException.none();
	
	static double ERROR_MARGIN = 0.000000001d;
	
	@Test
	public void test_createNumberArray_nullArray() {
		exceptions.expect(InvalidParameterException.class);
		DataUtilities.createNumberArray(null);
	}
	
	@Test
	public void test_createNumberArray_emptyArraySizeZero(){
		double[] emptyArray = new double[0];
		Number[] result = DataUtilities.createNumberArray(emptyArray);
		Number[] expected = new Number[0];
		assertArrayEquals("An array of double of size 0 should return an array of Number of size 0", expected, result);
	}
	
	@Test
	public void test_createNumberArray_arrayWithDecimalValues(){
		double[] array = {1.1, 2.2, 3.3};
		Number[] result = DataUtilities.createNumberArray(array);
		Number[] expected = {1.1, 2.2, 3.3};
		assertArrayEquals("Expected an array of Number containing {1.1, 2.2, 3.3}", expected, result);
	}
	
	@Test
	public void test_createNumberArray_arrayWithIntegerValues(){
		double[] array = {1, 2, 0};
		Number[] result = DataUtilities.createNumberArray(array);
		Number[] expected = {1.0, 2.0, 0.0};
		assertArrayEquals("Expected an array of Number containing {1.0, 2.0, 0.0}", expected, result);
	}
	
	@Test
	public void test_createNumberArray_arrayWithIntegerAndDecimalValues(){
		double[] array = {0.0, 2.0, 3.3};
		Number[] result = DataUtilities.createNumberArray(array);
		Number[] expected = {0.0, 2.0, 3.3};
		assertArrayEquals("Expected an array of Number containing {0.0, 2.0, 3.3}", expected, result);
	}
}
