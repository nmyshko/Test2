package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YourCartTest extends BaseTest {
    @Test

    public void YourCartSuccessfulTest() {
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password()).
                isPageOpened());
        Assert.assertTrue(userStep.addToCartSuccessful().isPageOpened());
        Assert.assertTrue(userStep.moveToChekckoutPageSuccessful().isPageOpened());
    }
}
