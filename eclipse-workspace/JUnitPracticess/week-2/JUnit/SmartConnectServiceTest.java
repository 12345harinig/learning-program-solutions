package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SmartConnectServiceTest {

    @Test
    public void testSequentialReturnValues() {
        // Step 1: Mock client
        NetworkClient mockClient = mock(NetworkClient.class);

        // Step 2: Stub connect() to return multiple values
        when(mockClient.connect())
            .thenReturn("Connecting...")
            .thenReturn("Connected");

        // Step 3: Inject mock
        SmartConnectService service = new SmartConnectService(mockClient);

        // Step 4: Call and assert
        String result = service.doubleConnect();
        assertEquals("Connecting... => Connected", result);

        System.out.println("Sequential test passed: " + result);
    }
}
