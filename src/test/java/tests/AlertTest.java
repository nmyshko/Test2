package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void infoAlertTest() {
//        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//
//        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
//
//        Alert alert = driver.switchTo().alert();
//
//        Assert.assertEquals(alert.getText(), "I am a JS Alert");
//
//        alert.accept();


        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement contextMenuButton = driver.findElement(By.id("[id=hot-spot]"));

        Actions action = new Actions(driver);

        action.contextClick(contextMenuButton).perform();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "You selected a context menu");

        alert.accept();
    }


    @Test
    public void confirmAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        alert.sendKeys("sdfsdf");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: sdfsdf");
    }
}
