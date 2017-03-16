package org.jfree.data.test;
import org.jfree.data.Range;
import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hilmi on 2/14/2017.
 * Last edited by Fernando on 2017-02-16.
 */
public class RangeTest_combine {
    @Rule
    public ExpectedException exceptions = ExpectedException.none();
    
    @Before
    public void setUp() throws Exception {

    }
    
    @Test
    public void test_combine_bothNullRanges() {
        Range actual = Range.combine(null, null);
        assertEquals("Expected combination of two null ranges to return null", null, actual);   
    }
    
    @Test 
    public void test_combine_firstNullRange(){	
    	Range r = new Range(2,10);
        Range actual = Range.combine(null, r);
        assertEquals("Expected combination of range (2, 10) and null to return a range of (2, 10)", r, actual);
        
    }
    
    @Test
    public void test_combine_secondNullRange(){
    	Range r = new Range(2, 10);
        Range actual = Range.combine(r, null);
        assertEquals("Expected combination of null and range (2, 10) to return a range of (2, 10)", r, actual);
    }
    
    @Test
    public void test_combine_noIntersectRanges(){
        Range t1 = new Range(1, 4);
        Range t2 = new Range(5, 10);
        Range actual = Range.combine(t1,t2);
        Range expected = new Range(1,10);
        assertEquals("Expected combined range of (1, 10)", expected, actual);
    }
    
    @Test
    public void test_combine_oneIntersect(){
        Range t1 = new Range(1, 4);
        Range t2 = new Range(4, 10);
        Range actual = Range.combine(t1,t2);
        
        Range expected = new Range(1,10);
        assertEquals("Expected combined range of (1, 10)", expected, actual);
    }
    
    @Test
    public void test_combine_oneIntersectSwitchParameters(){
        Range t1 = new Range(1, 4);
        Range t2 = new Range(4, 10);
        Range actual = Range.combine(t2,t1);
        
        Range expected = new Range(1,10);
        assertEquals("Expected combined range of (1, 10)", expected, actual);
    }
    
    @Test
    public void test_combine_rangeWithOverlap(){
        Range t1 = new Range(5, 7);
        Range t2 = new Range(4,10);
        Range actual = Range.combine(t1,t2);
        Range expected = new Range(4,10);
        assertEquals("Expected combined range of (4, 10)", expected, actual);
    }

    @After
    public void tearDown() throws Exception { }
    @AfterClass
    public static void tearDownAfterClass() throws Exception { }
}
