package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class PollingServiceTest {

    @Test
    public void testMultipleReturns() {
        // Step 1: Create mock
        MultiCallApi mockApi = Mockito.mock(MultiCallApi.class);

        // Step 2: Stub method with multiple returns
        when(mockApi.fetchStatus()).thenReturn("Pending", "Completed");

        // Step 3: Inject and use service
        PollingService service = new PollingService(mockApi);
        String result = service.checkStatusTwice();

        // Step 4: Assert final result
        assertEquals("Pending -> Completed", result);

        System.out.println("Test passed: " + result);
    }
}
