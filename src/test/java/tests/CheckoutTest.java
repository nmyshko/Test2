package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test

    public void YourCartSuccessfulTest() throws InterruptedException {
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password()).
                isPageOpened());
        Assert.assertTrue(userStep.addToCartSuccessful().isPageOpened());
        Assert.assertTrue(userStep.moveToChekckoutPageSuccessful().isPageOpened());
    }
}
