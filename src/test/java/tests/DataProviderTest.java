package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.data.StaticProvider;

public class DataProviderTest {
    CalculatorDivision calculator = new CalculatorDivision();
    @Test(dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class, threadPoolSize = 2)
    public void testDivInt(int a, int b, int expectedInt) {
            Assert.assertEquals(calculator.divInt(a, b), expectedInt, "Неверное значение!");
    }
    @Test(dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class, threadPoolSize = 2)
    public void testDivDouble(double c, double d, double expectedDoble) {
            Assert.assertEquals(calculator.divDouble(c, d), expectedDoble, "Неверное значение!");
    }
}