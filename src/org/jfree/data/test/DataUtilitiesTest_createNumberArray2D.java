package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;

import java.security.InvalidParameterException;

/**
 * Created by Hilmi on 2017-02-14.
 * Last edited by Fernando on 2017-02-15.
 */
public class DataUtilitiesTest_createNumberArray2D {
    @Rule
    public ExpectedException exceptions = ExpectedException.none();

    @Test
    public void test_createNumberArray2D_nullArray() {
        exceptions.expect(InvalidParameterException.class);
        DataUtilities.createNumberArray2D(null);
    }
    @Test
    public void test_createNumberArray2D_emptyArray(){
        double[][] test = new double[0][];
        
        Number[][] actual = DataUtilities.createNumberArray2D(test);
        Number[][] expected = new Number[0][];
        
        assertArrayEquals("An empty array of double should return an empty array of Number", expected, actual);
    }
    @Test
    public void test_createNumberArray2D_normalArray(){
        double[][] test = new double[10][10];
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                test[i][j] = i + 10 * j;
            }
        }
        Number[][] actual = DataUtilities.createNumberArray2D(test);
        assertArrayEquals("Arrays of double and Number do not match", test, actual);
    }

    @Test
    public void test_createNumberArray2D_largerArrayFunction(){
        double[][] test = new double[1000][1000];
        for(int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++){
                test[i][j] = i + 10 * j;
            }
        }
        Number[][] actual = DataUtilities.createNumberArray2D(test);
        assertArrayEquals("Large arrays of double and Number do not match", test, actual);

    }
    
    @Test
    public void test_createNumberArray2D_assymetricArrayFunction(){
        double[][] test = new double[10][40];
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 40; j++){
                test[i][j] = i + 10 * j;
            }
        }
        Number[][] actual = DataUtilities.createNumberArray2D(test);
        assertArrayEquals("Assymmetric arrays of double and Number do not match", test, actual);
    }

    @After
    public void tearDown() throws Exception { }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception { }
}
