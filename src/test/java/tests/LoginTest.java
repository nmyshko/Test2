package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.LoginPage;


public class LoginTest extends BaseTest {
    @Test
    public void loginSuccessfulTest() {

        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password()).
                isPageOpened());
    }
}