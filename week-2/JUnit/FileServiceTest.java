package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        // Step 1: Mock reader & writer
        FileReader mockReader = mock(FileReader.class);
        FileWriter mockWriter = mock(FileWriter.class);

        // Step 2: Stub the read method
        when(mockReader.read()).thenReturn("Mock File Content");

        // Step 3: Inject into FileService
        FileService fileService = new FileService(mockReader, mockWriter);

        // Step 4: Call the method
        String result = fileService.processFile();

        // Step 5: Assert and verify write interaction
        assertEquals("Processed Mock File Content", result);
        verify(mockWriter).write("Processed Mock File Content");

        System.out.println("File I/O test passed: " + result);
    }
}
