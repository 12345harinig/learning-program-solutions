package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // Step 1: Mock the client
        NetworkClient mockClient = mock(NetworkClient.class);

        // Step 2: Stub connect() to simulate network
        when(mockClient.connect()).thenReturn("Mock Connection");

        // Step 3: Inject into NetworkService
        NetworkService service = new NetworkService(mockClient);

        // Step 4: Call method and assert
        String result = service.connectToServer();
        assertEquals("Connected to Mock Connection", result);

        System.out.println("Network interaction test passed: " + result);
    }
}
