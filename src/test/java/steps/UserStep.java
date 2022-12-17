package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class UserStep extends BaseStep {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutPage checkoutPage;
    private OverviewPage overviewPage;
    private CheckoutCompletePage checkoutCompletePage;


    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);

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
    public void checkoutInfo(String firstname, String lastname, String zipcode) {
        checkoutPage.getFirstNameInput().sendKeys(firstname);
        checkoutPage.getLastNameInput().sendKeys(lastname);
        checkoutPage.getZipCodeInput().sendKeys(zipcode);
        checkoutPage.getContinueButton().click();
    }
    public void finish() {
        overviewPage.getFinishButton().click();
    }

    public ProductsPage loginSuccessful(String username, String psw) {
        login(username, psw);
        return new ProductsPage(driver);
    }

    public YourCartPage productsSuccessful() {
        products();
        return new YourCartPage(driver);
    }

    public CheckoutPage YourCartPageSuccessful() {
        yourCartPage();
        return new CheckoutPage(driver);
    }
    public OverviewPage moveToOverviewPageSuccessful(String firstname, String lastname, String zipcode) {
        checkoutInfo(firstname, lastname, zipcode);
        return new OverviewPage(driver);
    }

    public CheckoutCompletePage finishIsSuccesful() {
        finish();
        return new CheckoutCompletePage(driver);
    }
    public boolean backHome() {
        checkoutCompletePage.getBackHomeButton().click();
        return true;
    }
}