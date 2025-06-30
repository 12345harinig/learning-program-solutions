package com.example;

public class SmartConnectService {
    private NetworkClient client;

    public SmartConnectService(NetworkClient client) {
        this.client = client;
    }

    public String doubleConnect() {
        String first = client.connect();   // first call
        String second = client.connect();  // second call
        return first + " => " + second;
    }
}
