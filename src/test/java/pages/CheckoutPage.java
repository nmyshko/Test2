package pages;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By zipCodeInputLocator = By.id("postal-code");
    private final By continueButtonLocator = By.id("continue");

    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInputLocator);
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInputLocator);
    }

    public WebElement getZipCodeInput() {
        return driver.findElement(zipCodeInputLocator);
    }
    public WebElement getContinueButton() {
        return driver.findElement(continueButtonLocator);
    }

    private final By checkoutPageLocator = By.xpath("//*[@class='title' and text() = 'Checkout: Your Information']");

    @Override
    protected By getPageIdentifier() {
        return checkoutPageLocator;
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
}