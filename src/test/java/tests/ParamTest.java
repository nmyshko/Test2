package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
    @Parameters({"login-value", "psw-value"})
    @Test
    public void paramTest(String login, String psw) {
        System.out.println("Login is: ");
        System.out.println("Psw is: ");
    }
}
