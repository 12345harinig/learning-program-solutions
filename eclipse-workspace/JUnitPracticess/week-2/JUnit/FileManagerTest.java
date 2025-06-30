package com.example;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class FileManagerTest {

    @Test
    public void testVoidMethodWithException() {
        // Step 1: Create mock
        DangerousAction mockAction = mock(DangerousAction.class);

        // Step 2: Stub the void method to throw exception
        doThrow(new RuntimeException("File not found!"))
                .when(mockAction).deleteImportantFile("data.txt");

        // Step 3: Inject into FileManager
        FileManager manager = new FileManager(mockAction);

        // Step 4: Run the method and check output (or behavior)
        manager.deleteFileSafely("data.txt");

        // Step 5: Verify interaction
        verify(mockAction).deleteImportantFile("data.txt");

        System.out.println("Void method exception handled test passed.");
    }
}
