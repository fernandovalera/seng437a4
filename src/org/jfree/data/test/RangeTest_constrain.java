package org.jfree.data.test;
import org.jfree.data.Range;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hilmi on 2/14/2017.
 * Last edited by Fernando on 2017-02-15.
 */
public class RangeTest_constrain {

    @Rule
    public ExpectedException exceptions = ExpectedException.none();
    
    Range testRange;
    
	static double ERROR_MARGIN = 0.000000001d;
    
    @Before
    public void setUp() throws Exception {
        testRange = new Range(1.0, 5.0);
    }
    
    @Test
    public void test_constrains_lowOutOfBounds() {
        double actual = testRange.constrain(-1);
        double expected = 1.0;
        assertEquals("Expected result of constraint is 1.0", expected, actual, ERROR_MARGIN);
    }
    
    @Test
    public void test_constrains_highOutOfBounds() {
        double actual = testRange.constrain(6.0);
        double expected = 5.0;
        assertEquals("Expected result of constraint is 5.0", expected,  actual, ERROR_MARGIN);
    }
    
    @Test
    public void test_constrains_rangeInBounds(){
        double actual = testRange.constrain(3.0);
        double expected = 3.0;
        assertEquals("Expected result of constraint is 3.0", expected, actual, ERROR_MARGIN);
    }
    
    @After
    public void tearDown() throws Exception { }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception { }
}
