package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTest extends BaseTest {
    @Test
    public void backHomeSuccesfull() {
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .isPageOpened());
        Assert.assertTrue(userStep.productsSuccessful()
                .isPageOpened());
        Assert.assertTrue(userStep.YourCartPageSuccessful()
                .isPageOpened());
        Assert.assertTrue(userStep.moveToOverviewPageSuccessful(ReadProperties.firstname(), ReadProperties.lastname(), ReadProperties.zipCode())
                .isPageOpened());
        Assert.assertTrue(userStep.finishIsSuccesful()
                .isPageOpened());
        Assert.assertTrue(userStep.backHome());
    }
}