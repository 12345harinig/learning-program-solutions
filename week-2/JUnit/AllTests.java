package com.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CalculatorTest.class,
    EvenCheckerTest.class
})
public class AllTests {
    // This class remains empty
    // It is used only as a holder for the above annotations
}
