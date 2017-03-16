package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by hilmi on 2017-03-08.
 */
public class DataUtilitiesTest_calculateRowTotal_additional {
    @Rule
    public ExpectedException exceptions = ExpectedException.none();

    private Mockery mockingContext;
    private Values2D values;
    private IndexOutOfBoundsException indexOutOfBoundsException;

    static double ERROR_MARGIN = 0.000000001d;

    @Before
    public void setUp() {
    }

    @Test
    public void test_calculateRowTotal_nullFirstValue() {
        indexOutOfBoundsException = new IndexOutOfBoundsException();
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations(){
            {
                one(values).getColumnCount();
                will(returnValue(2));

                one(values).getValue(0, 0);
                will(returnValue(null));

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

        Number actual = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("The row total for 2.5 and null should be 2.5", 2.5, actual.doubleValue(), ERROR_MARGIN);

    }
    @Test
    public void test_calculateRowTotal_nullSecondValue() {
        indexOutOfBoundsException = new IndexOutOfBoundsException();
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations(){
            {
                one(values).getColumnCount();
                will(returnValue(2));

                one(values).getValue(0, 0);
                will(returnValue(2.5));

                one(values).getValue(0, 1);
                will(returnValue(null));

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

        Number actual = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("The row total for null and 2.5 should be 2.5", 2.5, actual.doubleValue(), ERROR_MARGIN);

    }
    @Test
    public void test_calculateRowTotal_nullValues() {
        indexOutOfBoundsException = new IndexOutOfBoundsException();
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations(){
            {
                one(values).getColumnCount();
                will(returnValue(2));

                one(values).getValue(0, 0);
                will(returnValue(null));

                one(values).getValue(0, 1);
                will(returnValue(null));

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

        Number actual = DataUtilities.calculateRowTotal(values, 0);
        assertEquals("The row total for both is 0.", 0, actual.doubleValue(), ERROR_MARGIN);

    }

}
