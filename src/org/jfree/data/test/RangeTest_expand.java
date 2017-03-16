package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

/**
 * Created by Hilmi on 2/14/2017.
 * Last edited by Fernando on 2017-02-15.
 */
public class RangeTest_expand {
    @Rule
    public ExpectedException exceptions = ExpectedException.none();
    
    Range testRange;

    @Before
    public void setUp() throws Exception {
        testRange = new Range(2.0, 6.0);
    }
    @Test
    public void test_expand_nullRange() {
        exceptions.expect(InvalidParameterException.class);
        Range.expand(null, .25, .5);
    }
    @Test
    public void test_expand_noChange() {
        Range actual = Range.expand(testRange, 0, 0);
        assertEquals("Expected testRange to not change", testRange, actual);
    }
    @Test
    public void test_expand_smallChangeInLowerMargin(){
        Range actual = Range.expand(testRange, .25, 0);
        Range expected = new Range(1.0, 6.0);
        assertEquals("New range should be (1.0, 6.0)", expected, actual);
    }
    @Test
    public void test_expand_largeChangeInUpperMargin(){
        Range actual = Range.expand(testRange, 0, 100.0);
        Range expected = new Range(2.0, 406.0);
        assertEquals("New range should be (2.0, 406.0)", expected, actual);
        //Should pass test. Issue lies in getUpperBound or Expand.
        //Problem is when debugging actual is not the value it should be, but it is still passing tests.
    }
    @Test
    public void test_expand_changeInLowerAndUpperMargin(){
        Range actual = Range.expand(testRange, .25, .5);
        Range expected = new Range(1.0, 8.0);
        assertEquals("New range should be (1.0, 8.0)", expected, actual);
    }
    @After
    public void tearDown() throws Exception { }
    @AfterClass
    public static void tearDownAfterClass() throws Exception { }
}
