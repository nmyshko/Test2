package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends BasePage {
    private final By finishButtonLocator = By.id("finish");

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }

    private final By overViewPageLocator = By.xpath("//*[@class=\"title\" and text() = 'Checkout: Overview']");

    @Override
    protected By getPageIdentifier() {
        return overViewPageLocator;
    }

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

}
