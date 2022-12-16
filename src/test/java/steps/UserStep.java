package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class UserStep extends BaseStep {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;


    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);

    }

    public void login(String username, String psw) {
        loginPage.getUserNameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLoginButton().click();
    }

    public void products() {
        productsPage.getAddToCartButton().click();
        productsPage.getShoppingCartButton().click();
    }

    public void yourCartPage() {
        yourCartPage.getcheckoutButton().click();
    }

    public ProductsPage loginSuccessful(String username, String psw) {
        login(username, psw);
        return new ProductsPage(driver);
    }

    public YourCartPage addToCartSuccessful() {
        products();
        return new YourCartPage(driver);
    }

    public CheckoutPage moveToChekckoutPageSuccessful() {
        yourCartPage();
        return new CheckoutPage(driver);
    }
}
