package com.example;

public class WorkflowService {
    private OrderDependentApi api;

    public WorkflowService(OrderDependentApi api) {
        this.api = api;
    }

    public void runWorkflow() {
        api.stepOne();
        api.stepTwo();
        api.stepThree();
    }
}
