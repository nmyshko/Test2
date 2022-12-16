package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By shoppingCartButtonLocator = By.className("shopping_cart_link");

    public WebElement getAddToCartButton() {
        return driver.findElement(addToCartButtonLocator);
    }
    public WebElement getShoppingCartButton() {
        return driver.findElement(shoppingCartButtonLocator);
    }
    private final By headerTitleLabelLocator = By.xpath("//*[contains(text(), 'Products')]");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }
}
