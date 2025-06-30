package com.example;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;

public class WorkflowServiceTest {

    @Test
    public void testInteractionOrder() {
        // Step 1: Create mock
        OrderDependentApi mockApi = mock(OrderDependentApi.class);

        // Step 2: Inject into service
        WorkflowService service = new WorkflowService(mockApi);
        service.runWorkflow();

        // Step 3: Verify interaction order
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).stepOne();
        inOrder.verify(mockApi).stepTwo();
        inOrder.verify(mockApi).stepThree();

        System.out.println("Interaction order verified successfully.");
    }
}
