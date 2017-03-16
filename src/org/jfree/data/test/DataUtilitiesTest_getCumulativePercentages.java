package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.DefaultKeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

/**
 * Created by Hilmi on 2017-02-14.
 * Last edited by Fernando on 2017-02-15.
 */
public class DataUtilitiesTest_getCumulativePercentages {
    @Rule
    public ExpectedException exceptions = ExpectedException.none();
    
    public static double ERROR_MARGIN = 0.000000001d;
    
    @BeforeClass
    public static void setUpBeforeClass()
            throws Exception { }
    @Before
    public void setUp() throws Exception {}
    
    @Test
    public void test_getCumulativePercentages_nullInput(){
        exceptions.expect(InvalidParameterException.class);
        DataUtilities.getCumulativePercentages(null);
    }
    
    @Test
    public void test_getCumulativePercentages_noKeyedValues() {
        KeyedValues kv = new DefaultKeyedValues();

        KeyedValues actual = DataUtilities.getCumulativePercentages(kv);
        KeyedValues expected = new DefaultKeyedValues();
        assertEquals("The result of calling cumulative percentage on an empty KeyedValues should be an empty KeyedValues", expected, actual);
    }
    
    @Test
    public void test_getCumulativePercentages_oneKeyedValue() {
		// setup
		Mockery mockingContext = new Mockery();

		final int key0 = 0;
		
		final Number value0 = 5;
		
		final KeyedValues kv = mockingContext.mock(KeyedValues.class);	
		mockingContext.checking(new Expectations() {
		{
			allowing(kv).getItemCount();
			will(returnValue(1));
			atLeast(1).of(kv).getKey(0);
			will(returnValue(key0));
			atLeast(1).of(kv).getValue(0);
			will(returnValue(value0));
		}
		});

        KeyedValues actual = DataUtilities.getCumulativePercentages(kv);
        
		final Number expectedValue0 = 1.0;
        
        assertEquals("The cumulative percentage of 5 of {5} should be 1.0", expectedValue0.doubleValue(), actual.getValue(key0).doubleValue(), ERROR_MARGIN);
    }

	@Test
	public void test_getCumulativePercentages_twoKeyedValue() {
		// setup
		Mockery mockingContext = new Mockery();

		final int key0 = 0;
		final int key1 = 1;
		final Number value0 = 5;
		final Number value1 = null;

		final KeyedValues kv = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(kv).getItemCount();
				will(returnValue(1));
				atLeast(1).of(kv).getKey(0);
				will(returnValue(key0));
				atLeast(1).of(kv).getValue(0);
				will(returnValue(value0));
				atLeast(1).of(kv).getKey(1);
				will(returnValue(key1));
				atLeast(1).of(kv).getValue(1);
				will(returnValue(value1));
			}
		});

		KeyedValues actual = DataUtilities.getCumulativePercentages(kv);

		final Number expectedValue0 = 1.0;

		assertEquals("The cumulative percentage of 5 of {5, null} should still be 1.0", expectedValue0.doubleValue(), actual.getValue(key0).doubleValue(), ERROR_MARGIN);
	}
    
    @Test
    public void test_getCumulativePercentages_threeKeyedValue() {
		// setup
		Mockery mockingContext = new Mockery();

		final int itemCount = 3;

		final int key0 = 0;
		final int key1 = 1;
		final int key2 = 2;

		final Number value0 = 5;
		final Number value1 = 9;
		final Number value2 = 2;

		final KeyedValues kv = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(kv).getItemCount();
				will(returnValue(itemCount));
				atLeast(1).of(kv).getKey(0);
				will(returnValue(key0));
				atLeast(1).of(kv).getKey(1);
				will(returnValue(key1));
				atLeast(1).of(kv).getKey(2);
				will(returnValue(key2));
				atLeast(1).of(kv).getValue(key0);
				will(returnValue(value0));
				atLeast(1).of(kv).getValue(key1);
				will(returnValue(value1));
				atLeast(1).of(kv).getValue(key2);
				will(returnValue(value2));
			}
		});

		KeyedValues actual = DataUtilities.getCumulativePercentages(kv);

		final Number expectedValue0 = 0.3125;
		final Number expectedValue1 = 0.875;
		final Number expectedValue2 = 1.0;

		assertEquals("The cumulative percentage of 5 of {5, 9, 2} should be 0.3125", expectedValue0.doubleValue(), actual.getValue(key0).doubleValue(), ERROR_MARGIN);
		assertEquals("The cumulative percentage of 5, 9 of {5, 9, 2} should be 0.875", expectedValue1.doubleValue(), actual.getValue(key1).doubleValue(), ERROR_MARGIN);
		assertEquals("The cumulative percentage of 5, 9, 2 of {5, 9, 2} should be 1.0", expectedValue2.doubleValue(), actual.getValue(key2).doubleValue(), ERROR_MARGIN);
    }
    
    @Test
    public void test_getCumulativePercentages_oneKeyedValue_nullValue() {
		// setup
		Mockery mockingContext = new Mockery();

		final int key0 = 0;
		final Number value0 = null;
		
		final KeyedValues kv = mockingContext.mock(KeyedValues.class);	
		mockingContext.checking(new Expectations() {
		{
			allowing(kv).getItemCount();
			will(returnValue(1));
			atLeast(1).of(kv).getKey(0);
			will(returnValue(key0));
			atLeast(1).of(kv).getValue(0);
			will(returnValue(value0));
		}
		});

        KeyedValues actual = DataUtilities.getCumulativePercentages(kv);
        
		final Number expectedValue0 = 0.0;
        
        assertEquals("The cumulative percentage of null of {null} should be 0.0", expectedValue0.doubleValue(), actual.getValue(key0).doubleValue(), ERROR_MARGIN);
    }
    
    @After
    public void tearDown() throws Exception { }
    @AfterClass
    public static void tearDownAfterClass() throws Exception { }
}
