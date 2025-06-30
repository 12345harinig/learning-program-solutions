package com.example;

public class ExceptionThrower {

    public void throwException(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message must not be null or empty!");
        }
        System.out.println("Message: " + message);
    }
}
