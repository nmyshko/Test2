package tests;

import baseEntities.BasePage;
import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test

    public void productsSuccessfulTest() {
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password()).
                isPageOpened());
        Assert.assertTrue(userStep.productsSuccessful().isPageOpened());
    }
}