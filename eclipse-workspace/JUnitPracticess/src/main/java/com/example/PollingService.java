package com.example;

public class PollingService {
    private MultiCallApi api;

    public PollingService(MultiCallApi api) {
        this.api = api;
    }

    public String checkStatusTwice() {
        String firstCall = api.fetchStatus();
        String secondCall = api.fetchStatus();
        return firstCall + " -> " + secondCall;
    }
}
