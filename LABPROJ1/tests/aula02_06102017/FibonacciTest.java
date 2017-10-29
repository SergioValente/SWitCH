/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02_06102017;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import aula02_06102017.Fibonacci;

import static org.junit.Assert.*;

/**
 *
 * @author sergiovalente
 */
public class FibonacciTest {
    
    public FibonacciTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Fibonacci.
     */
    @Test @Ignore
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Fibonacci.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fibonacci method, of class Fibonacci.
     */
    @Test @Ignore
    public void testFibonacci() {
        System.out.println("fibonacci");
        Fibonacci.fibonacci();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
