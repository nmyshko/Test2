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

public class CalcEPT {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void calcEPT() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement widthInput = driver.findElement(By.id("el_f_width"));
        widthInput.sendKeys("3");

        WebElement lengthInput = driver.findElement(By.id("el_f_lenght"));
        lengthInput.sendKeys("4");

        WebElement selectWebElement = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(selectWebElement);
        selectRoom.selectByValue("3");
        selectRoom.selectByValue("4");
        Thread.sleep(3000);

        WebElement selectWebElement1 = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(selectWebElement1);
        selectHeatingType.selectByValue("2");
        selectHeatingType.selectByValue("3");
        Thread.sleep(3000);

        WebElement heatLossInput = driver.findElement(By.id("el_f_losses"));
        heatLossInput.sendKeys("2500");

        WebElement calcButton = driver.findElement(By.className("buttHFcalc"));
        Thread.sleep(3000);
        calcButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[text() = 'Мощность нагревательного кабеля или мата, Вт']")).getText(),
                "Мощность нагревательного кабеля или мата, Вт");
        Assert.assertEquals(driver.findElement(By.xpath("//*[text() = 'Удельная мощность нагревательного кабеля или мата, Вт/м']")).getText(),
                "Удельная мощность нагревательного кабеля или мата, Вт/м2");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}