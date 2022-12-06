package tests.data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider (name = "dataForDiv")
    public static Object[][] dataForDivTests() {
        return new Object[][] {
                {10, 2, 5},
                {5, 0, 0},
                {-10.0, -2, 5}
        };
    }
}
