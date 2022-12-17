package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {
    private final By backHomeButtonLocator = By.id("back-to-products");

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButtonLocator);
    }

    private final By checkoutCompletePageLocator = By.xpath("//*[@class=\"title\" and text()='Checkout: Complete!']");

    @Override
    protected By getPageIdentifier() {
        return checkoutCompletePageLocator;
    }

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
}