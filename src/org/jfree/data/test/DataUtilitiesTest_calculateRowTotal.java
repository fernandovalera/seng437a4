package org.jfree.data.test;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * Last edited by Fernando on 2017-02-15.
 */
public class DataUtilitiesTest_calculateRowTotal{
	
    @Rule
    public ExpectedException exceptions = ExpectedException.none();
    
	private Mockery mockingContext;
	private Values2D values;
	private IndexOutOfBoundsException indexOutOfBoundsException;
	
	static double ERROR_MARGIN = 0.000000001d;
	
	@Before
	public void setUp() {
		indexOutOfBoundsException = new IndexOutOfBoundsException();
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				one(values).getColumnCount(); 	
				will(returnValue(2));		
					
				one(values).getValue(0, 0);	
				will(returnValue(7.5));		
				
				one(values).getValue(0, 1);
				will(returnValue(2.5));		
				
				one(values).getValue(-1, 0);
				will(throwException(indexOutOfBoundsException));
				
				one(values).getValue(-1, 1);
				will(throwException(indexOutOfBoundsException));
				
				one(values).getValue(1, 0);
				will(throwException(indexOutOfBoundsException));
				
				one(values).getValue(1, 1);
				will(throwException(indexOutOfBoundsException));
				
				one(values).getColumnCount();
				will(returnValue(1));
			}
		});
		
		
	}
	
	@Test
	public void test_calculateRowTotal_rowGreaterThanMaxIndexOfData() {
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals("The row total for an index-out-of-bounds row should be 0", 0, result, ERROR_MARGIN);
	}
	 
	@Test
	public void test_calculateRowTotal_rowLessThenZero(){
		double result = DataUtilities.calculateRowTotal(values, -1);
		assertEquals("The row total for an index-out-of-bounds row should be 0", 0, result, ERROR_MARGIN);
	}
	
	@Test
	public void test_calculateRowTotal_twoValuesInRow(){
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The row total for 7.5 and 2.5 should be 10.0", 10.0, result, ERROR_MARGIN);
	}
	
	@Test
	public void test_calculateRowTotal_nullData(){
		exceptions.expect(InvalidParameterException.class);
		DataUtilities.calculateRowTotal(null, 0);			
	}
}
