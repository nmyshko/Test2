package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage extends BasePage {

    private final By checkoutButtonLocator = By.id("checkout");

    public WebElement getcheckoutButton() {
        return driver.findElement(checkoutButtonLocator);
    }
    private final By yourCartLocator = By.xpath("//*[@class=\"title\"]");

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return yourCartLocator;
    }
}
