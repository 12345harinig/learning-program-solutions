package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {
        // Step 1: Create mock repository
        Repository mockRepo = mock(Repository.class);

        // Step 2: Stub getData() to return mock value
        when(mockRepo.getData()).thenReturn("Mock Data");

        // Step 3: Inject mock into Service
        Service service = new Service(mockRepo);

        // Step 4: Call and verify result
        String result = service.processData();
        assertEquals("Processed Mock Data", result);

        System.out.println("Test Passed: " + result);
    }
}
