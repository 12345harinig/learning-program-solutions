package com.example;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import org.junit.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        // Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub method
        when(mockApi.getData(anyString())).thenReturn("Mocked Response");

        // Use service
        MyService service = new MyService(mockApi);
        String result = service.fetchData("hello");

        // Assert result
        assert result.equals("Mocked Response");

        // Verify argument used in method call
        verify(mockApi).getData(eq("hello"));

        System.out.println("testArgumentMatching passed with input: hello");
    }
}
