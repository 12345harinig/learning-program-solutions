package com.example;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class NotificationServiceTest {

    @Test
    public void testVoidMethodInteraction() {
        // Step 1: Create mock
        Notifier mockNotifier = Mockito.mock(Notifier.class);

        // Step 2: Use mock with service
        NotificationService service = new NotificationService(mockNotifier);
        service.alertUser();

        // Step 3: Verify the void method was called with expected message
        verify(mockNotifier).sendNotification("Your action was successful!");

        System.out.println("Void method verified successfully!");
    }
}
