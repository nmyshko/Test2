package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalcLaminat {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void CalcLaminat() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
        selectWebElement.click();
        Select installLaminate = new Select(selectWebElement);
        installLaminate.selectByValue("1");
        Thread.sleep(1500);

        WebElement roomLenght = driver.findElement(By.id("ln_room_id"));
        roomLenght.clear();
        roomLenght.sendKeys("500");
        Thread.sleep(1500);

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");
        Thread.sleep(1500);

        WebElement laminateLenght = driver.findElement(By.id("ln_lam_id"));
        laminateLenght.clear();
        laminateLenght.sendKeys("1200");
        Thread.sleep(2000);

        WebElement laminateWidth = driver.findElement(By.id("wd_lam_id"));
        laminateWidth.clear();
        laminateWidth.sendKeys("200");
        Thread.sleep(1500);

        WebElement directionLaminate = driver.findElement(By.id("direction-laminate-id1"));
        directionLaminate.click();

        WebElement numOfPanels = driver.findElement(By.id("n_packing"));
        numOfPanels.clear();
        numOfPanels.sendKeys("6");
        Thread.sleep(1500);

        WebElement indentWalls = driver.findElement(By.id("indent_walls_id"));
        indentWalls.clear();
        indentWalls.sendKeys("9");
        Thread.sleep(1500);

        WebElement directionsLaminate = driver.findElement(By.xpath("//*[text() ='по диагонали 45°']"));
        directionsLaminate.click();
        Thread.sleep(1500);

        WebElement resultButton = driver.findElement(By.className("calc-btn"));
        resultButton.click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[starts-with(@style, 'padding:5px 0;font-size:22px; color:#C80303; font-weight:bold;')]")).getText(),
                "97");
        Assert.assertEquals(driver.findElement(By.xpath("//*[starts-with(@style, 'padding:5px 0;font-size:18px; color:#0E8C19; font-weight:bold;')]")).getText(),
                "17");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}