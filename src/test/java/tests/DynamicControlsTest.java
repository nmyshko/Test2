package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void implicitlyVisibilityTest() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        WaitsService waitsService = new WaitsService(driver, Duration.ofSeconds(10));

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkBoxButton = waitsService.waitForVisibilityBy(By.xpath("//*[@type=\"checkbox\"]"));
        checkBoxButton.click();

        WebElement removeButton = waitsService.waitForVisibilityBy(By.tagName("button"));
        removeButton.click();

        WebElement loading = waitsService.waitForVisibilityBy(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(waitsService.waitForElementInvisible(loading));

        Assert.assertTrue(waitsService.waitForVisibilityBy(By.id("message")).isDisplayed());

        Assert.assertTrue(waitsService.waitForElementInvisible(checkBoxButton));

        Assert.assertTrue(waitsService.waitForVisibilityBy(By.cssSelector("form>input")).isDisplayed());

        WebElement enableButton = waitsService.waitForVisibilityBy(By.xpath("//button[contains(text(), 'Enable')]"));
        enableButton.click();

        Assert.assertTrue(waitsService.waitForVisibilityBy(By.id("message")).isDisplayed());

        Assert.assertTrue(waitsService.waitForVisibilityBy(By.xpath("//button[contains(text(), 'Disable')]")).isDisplayed());

    }
}