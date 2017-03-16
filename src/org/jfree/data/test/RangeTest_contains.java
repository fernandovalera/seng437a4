package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hilmi on 2/14/2017.
 * Last edited by Fernando on 2017-02-15.
 */
public class RangeTest_contains {
    Range testRange;

    @Before
    public void setUp() throws Exception {
        testRange = new Range(1.0, 5.0);
    }
    @Test
    public void test_contains_lowOutOfBounds() {
        boolean actual = testRange.contains(-1);
        assertEquals("-1 is not contained in the range (1.0, 5.0)", false, actual);
    }
    @Test
    public void test_contains_highOutOfBounds() {
        boolean actual = testRange.contains(6);
        assertEquals("6 is not contained in range (1.0, 5.0)", false, actual);
    }
    @Test
    public void test_contains_inBounds(){
        boolean actual = testRange.contains(4);
        assertEquals("4 is contained in 1.0 and 5.0", true, actual);

    }
    @After
    public void tearDown() throws Exception { }
    @AfterClass
    public static void tearDownAfterClass() throws Exception { }
}
