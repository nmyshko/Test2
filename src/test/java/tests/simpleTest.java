package tests;

import org.testng.annotations.Test;

public class simpleTest extends BaseTest {
    @Test
    public void test1() {
        System.out.println("Это мой первый тест");
    }
    @Test
    public void test2() {
        System.out.println("Это мой второй тест");
    }
}
