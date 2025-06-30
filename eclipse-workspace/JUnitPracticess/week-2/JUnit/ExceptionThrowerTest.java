package com.example;

import org.junit.Test;

public class ExceptionThrowerTest {

    ExceptionThrower thrower = new ExceptionThrower();

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionWithEmptyString() {
        thrower.throwException("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionWithNull() {
        thrower.throwException(null);
    }

    @Test
    public void testThrowExceptionWithValidInput() {
        thrower.throwException("Hello, Harini!");
    }
}
