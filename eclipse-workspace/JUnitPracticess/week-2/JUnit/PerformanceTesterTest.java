package com.example;

import org.junit.Test;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test(timeout = 500)  // Test fails if takes more than 500 ms
    public void testPerformTaskWithinTime() throws InterruptedException {
        tester.performTask();  // should pass (300 ms < 500 ms)
        System.out.println("Task completed within 500ms.");
    }

    @Test(timeout = 100)  // This should fail on purpose
    public void testPerformTaskTimeoutFail() throws InterruptedException {
        tester.performTask();  // should fail (300 ms > 100 ms)
        System.out.println("This line may not be printed if timeout fails.");
    }
}
