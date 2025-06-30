package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData(String input) {
        return api.getData(input);  // Now passes the input to ExternalApi
    }
}
