package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class ApiServiceTest {

    @Test
    public void testFetchData() {
        // Mock the RestClient
        RestClient mockClient = mock(RestClient.class);
        when(mockClient.getResponse()).thenReturn("Mock Response");

        // Inject into service
        ApiService service = new ApiService(mockClient);

        // Assert
        String result = service.fetchData();
        assertEquals("Fetched Mock Response", result);
    }
}
