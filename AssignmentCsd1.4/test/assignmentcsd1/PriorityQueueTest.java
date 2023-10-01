/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package assignmentcsd1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 84384
 */
public class PriorityQueueTest {
    
    public PriorityQueueTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class PriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PriorityQueue instance = new PriorityQueue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class PriorityQueue.
     */
    @Test
    public void testContains_PriorityQueueNode_GenericType() {
        System.out.println("contains");
        PriorityQueue instance = new PriorityQueue();
        boolean expResult = false;
        boolean result = instance.contains(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class PriorityQueue.
     */
    @Test
    public void testContains_GenericType() {
        System.out.println("contains");
        Object find = null;
        PriorityQueue instance = new PriorityQueue();
        boolean expResult = false;
        boolean result = instance.contains(find);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of height method, of class PriorityQueue.
     */
    @Test
    public void testHeight_PriorityQueueNode() {
        System.out.println("height");
        PriorityQueue instance = new PriorityQueue();
        int expResult = 0;
        int result = instance.height(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of height method, of class PriorityQueue.
     */
    @Test
    public void testHeight_0args() {
        System.out.println("height");
        PriorityQueue instance = new PriorityQueue();
        int expResult = 0;
        int result = instance.height();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printArcodingDegree method, of class PriorityQueue.
     */
    @Test
    public void testPrintArcodingDegree_PriorityQueueNode_int() {
        System.out.println("printArcodingDegree");
        PriorityQueue instance = new PriorityQueue();
        instance.printArcodingDegree(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printArcodingDegree method, of class PriorityQueue.
     */
    @Test
    public void testPrintArcodingDegree_0args() {
        System.out.println("printArcodingDegree");
        PriorityQueue instance = new PriorityQueue();
        instance.printArcodingDegree();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class PriorityQueue.
     */
    @Test
    public void testAdd_3args() {
        System.out.println("add");
        PriorityQueue instance = new PriorityQueue();
        instance.add(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class PriorityQueue.
     */
    @Test
    public void testAdd_Comparable() {
        System.out.println("add");
        PriorityQueue instance = new PriorityQueue();
        instance.add(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class PriorityQueue.
     */
    @Test
    public void testSize_PriorityQueueNode() {
        System.out.println("size");
        PriorityQueue instance = new PriorityQueue();
        int expResult = 0;
        int result = instance.size(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class PriorityQueue.
     */
    @Test
    public void testSize_0args() {
        System.out.println("size");
        PriorityQueue instance = new PriorityQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class PriorityQueue.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        PriorityQueue instance = new PriorityQueue();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class PriorityQueue.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        PriorityQueue instance = new PriorityQueue();
        Object expResult = null;
        Object result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNode method, of class PriorityQueue.
     */
    @Test
    public void testGetNode() {
        System.out.println("getNode");
        PriorityQueue instance = new PriorityQueue();
        PriorityQueue.Node expResult = null;
        PriorityQueue.Node result = instance.getNode(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class PriorityQueue.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object e = null;
        PriorityQueue instance = new PriorityQueue();
        instance.remove(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PriorityQueue.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PriorityQueue.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
