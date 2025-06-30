package com.example;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderedTests {

    @Test
    public void test1_Login() {
        System.out.println("Running Login test");
        assertTrue(true);
    }

    @Test
    public void test2_LoadDashboard() {
        System.out.println("Running LoadDashboard test");
        assertTrue(true);
    }

    @Test
    public void test3_Logout() {
        System.out.println("Running Logout test");
        assertTrue(true);
    }
}
