package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        System.out.println("Running assertion tests...");

        // assertEquals
        assertEquals("Addition result is wrong", 5, 2 + 3);
        System.out.println("assertEquals passed");

        // assertTrue
        assertTrue("5 should be greater than 3", 5 > 3);
        System.out.println("assertTrue passed");

        // assertFalse
        assertFalse("5 should not be less than 3", 5 < 3);
        System.out.println("assertFalse passed");

        // assertNull
        String nullString = null;
        assertNull("String should be null", nullString);
        System.out.println("assertNull passed");

        // assertNotNull
        Object obj = new Object();
        assertNotNull("Object should not be null", obj);
        System.out.println("assertNotNull passed");

        System.out.println("All assertions passed successfully!");
    }
}
