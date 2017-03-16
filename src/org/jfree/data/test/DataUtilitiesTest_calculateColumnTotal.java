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
public class DataUtilitiesTest_calculateColumnTotal{
	
    @Rule
    public ExpectedException exceptions = ExpectedException.none();
    
	private Mockery mockingContext;
	private Values2D values;
	private IndexOutOfBoundsException indexOutOfBoundsException;
	
	static double ERROR_MARGIN = 0.000000001d;
	
	@Before
	public void setUp() throws Exception {
		indexOutOfBoundsException = new IndexOutOfBoundsException();
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){ 
			{
				one(values).getRowCount(); 	//Checking one call of getRowCount() on values 
				will(returnValue(2));		//will return the value 2.
					
				one(values).getValue(0, 0);	//Checking one call of getValue() on values
				will(returnValue(7.5));		//will return the value 7.5.
				
				one(values).getValue(1, 0);	//Checking one call of getValue() on values
				will(returnValue(2.5));		//will return the value 2.5.
				
				one(values).getValue(0, 1);
				will(throwException(indexOutOfBoundsException));
				
				one(values).getValue(1, 1);
				will(throwException(indexOutOfBoundsException));
				
				one(values).getValue(0, -1);
				will(throwException(indexOutOfBoundsException));
				
				one(values).getValue(1, -1);
				will(throwException(indexOutOfBoundsException));
				
			}
		});
	}	
	
	
	@Test 
	public void test_calculateColumnTotal_columnIndexGreaterThanMaxIndexOfData() {
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("The column total for an out of index column should be 0", 0, result, ERROR_MARGIN);
	}
	
	
	@Test
	public void test_calculateColumnTotal_columnIndexLessThenZero(){
		double result = DataUtilities.calculateColumnTotal(values, -1);
		assertEquals("The column total for an out of index column should be 0", 0, result, ERROR_MARGIN);
	}
	
	
	@Test
	public void test_calculateColumnTotal_calculateColumnTotalForTwoValues(){
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The column total of 7.5 and 2.5 should be 10.0", 10.0, result, ERROR_MARGIN);
	}
	
	@Test
	public void test_calculateColumnTotal_nullData() {
		exceptions.expect(InvalidParameterException.class);
		DataUtilities.calculateColumnTotal(null, 0);			
	} 
}
