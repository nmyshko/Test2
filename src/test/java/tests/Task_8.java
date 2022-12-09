package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_8 {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }


    @Test
    public void products() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");
        Thread.sleep(2000);
        WebElement passwordInput = driver.findElement(By.cssSelector("[id$='ord']"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement addButton = driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory' and @id='add-to-cart-sauce-labs-bike-light']"));
//        WebElement addButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addButton.click();
        Thread.sleep(2000);
        WebElement catronButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
//        WebElement catronButton = driver.findElement(By.className("shopping_cart_link"));
        catronButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='inventory_item_price']")).getText(),
                "$9.99");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Sauce')]")).getText(),
                "Sauce Labs Bike Light");
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
