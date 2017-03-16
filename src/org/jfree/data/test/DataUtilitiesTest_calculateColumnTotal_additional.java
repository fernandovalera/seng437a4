package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by hilmi on 2017-03-08.
 */
public class DataUtilitiesTest_calculateColumnTotal_additional {
    @Rule
    public ExpectedException exceptions = ExpectedException.none();

    private Mockery mockingContext;
    private Values2D values;
    private IndexOutOfBoundsException indexOutOfBoundsException;

    static double ERROR_MARGIN = 0.000000001d;
    @Test
    public void test_calculateColumnTotal_nullValues() {
        indexOutOfBoundsException = new IndexOutOfBoundsException();
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations(){
            {
                one(values).getRowCount(); 	// Checking one call of getRowCount() on values
                will(returnValue(2));		// will return the value 2.

                one(values).getValue(0, 0);	//Checking one call of getValue() on values
                will(returnValue(null));		//will return the value null.

                one(values).getValue(1, 0);	//Checking one call of getValue() on values
                will(returnValue(null));		//will return the value null.

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

        Number result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The column total of null and null should be 0.0", 0.0, result.doubleValue(), ERROR_MARGIN);

    }

    @Test
    public void test_calculateColumnTotal_secondNullValue() {
        indexOutOfBoundsException = new IndexOutOfBoundsException();
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations(){
            {
                one(values).getRowCount(); 	//Checking one call of getRowCount() on values
                will(returnValue(2));		//will return the value 2.

                one(values).getValue(0, 0);	//Checking one call of getValue() on values
                will(returnValue(2.5));		//will return the value 7.5.

                one(values).getValue(1, 0);	//Checking one call of getValue() on values
                will(returnValue(null));		//will return the value null.

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

        Number result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The column total of 2.5 and null should be 2.5", 2.5, result.doubleValue(), ERROR_MARGIN);

    }

    @Test
    public void test_calculateColumnTotal_firstNullValue() {
        indexOutOfBoundsException = new IndexOutOfBoundsException();
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations(){
            {
                one(values).getRowCount(); 	//Checking one call of getRowCount() on values
                will(returnValue(2));		//will return the value 2.

                one(values).getValue(0, 0);	//Checking one call of getValue() on values
                will(returnValue(null));		//will return the value null.

                one(values).getValue(1, 0);	//Checking one call of getValue() on values
                will(returnValue(10));		//will return the value 10.

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

        Number result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The column total of null and 10 should be 10", 10, result.doubleValue(), ERROR_MARGIN);

    }

}
