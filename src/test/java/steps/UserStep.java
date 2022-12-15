package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class UserStep extends BaseStep {
    private LoginPage loginPage;
    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }
    public void login(String username, String psw) {
        loginPage.getUserNameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLoginButton().click();
    }
    public ProductsPage loginSuccessful(String username, String psw) {
        login(username,psw);
        return new ProductsPage(driver);
    }
    public LoginPage loginIncorrect(String username, String psw) {
        login(username,psw);
        return loginPage;
    }
}
