package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrsTest {
    @Parameters({"firstValue", "secondValue"})
    @Test
    public void paramTest(String firstValue, String secondValue) {
        System.out.println("First Value is: ");
        System.out.println("Second Value is: ");
    }
}
