package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalculatorDivisionTest extends BaseTest {

    @Test(priority = 0, groups = "divInt", description = "Этот тест проверяет деление целых чисел")
    public void testDivInt() {
        Assert.assertEquals(calculator.divInt(10, 2), 5, "Неверное значение!");
    }

    @Test(priority = 1, groups = "divDouble", dependsOnMethods = {"testDivDoble", "testDivInt"}, alwaysRun = true, description = "Этот тест проверяет деление дробных чисел и зависит от теста testDinInt а так же выполняется даже если testDivInt упал")
    public void testDivDoble() {
        Assert.assertEquals(calculator.divDouble(10.0, 2.0), 5, "Неверное значение!");
    }

    @Test(priority = 3, timeOut = 300, description = "TimeOut определяет, что тест должен выполниться за 300 миллисекунд")
    public void testTimeOut() {
        Assert.assertEquals(calculator.divDouble(10.0, 2), 6, "Неверное значение!");
    }

    @Test(priority = 4, groups = "divInt", invocationCount = 3, invocationTimeOut = 5, threadPoolSize = 3, description = "Этот метод определяет, что тест выполняется 3 раза за 5 миллисекунд в трех потоках, которые приостанавляиваются на 500 миллисекунд")
    public void testTimeCountInt() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.divInt(10, 2), 5, "Неверное значение!");
    }

    @Test(priority = 5, groups = "divDouble", invocationCount = 2, invocationTimeOut = 5)
    public void testTimeСountDouble() {
        Assert.assertEquals(calculator.divDouble(10.0, 2), 5, "Неверное значение!");
    }

    @Test(enabled = false)
    public void skipTest() {
        System.out.println("Этот тест пропускается с помощью атрибута enabled");
    }

    @Test(expectedExceptions = ArithmeticException.class, description = "тест успешен, если предугадана и обработана ошибка")
    public void testDivIntByZero() {
        Assert.assertEquals(calculator.divInt(10, 0), 6, "Неверное значение!");
    }

    @Test
    public void testDivNegDoubleByZero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, -10.0 / 0);
    }

    @Test
    public void testDivPoxDoubleByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, 10.0 / 0);
    }
}