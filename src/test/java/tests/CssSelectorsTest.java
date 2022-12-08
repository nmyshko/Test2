package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssLocatorsTest() {
        driver.get("C:\\Users\\User\\IdeaProjects\\Test2\\src\\test\\resources\\index.html");
        //Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Adress")).isDisplayed());
        //Поиск по класснейму
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());
        // Поиск по нескольким значениям в атрибуте класс
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());
        // Поиск по tag name
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
        // Поиск по tag name и значению class name
        Assert.assertTrue(driver.findElement(By.tagName("div.intro")).isDisplayed());
        //Поиск элемента по class bname  с учетом иерархии
        Assert.assertEquals(driver.findElements(By.tagName("#Lastname .markup")).size(), 2);
        //первый элемент - поиск родительского, второй - поиск вложенного элемента
//        "Space" - символ законченности поиска первого элемента перед поиском второго
        // Поиск всех элементов с tag name h1 или p
        Assert.assertEquals(driver.findElements(By.tagName("h1, p")).size(), 8);

        // Поиск всех элементов с тэгом p у которых непосредственный родитель с тэгом div
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());
        // Поиск всех элементов с тэгом p которые идут сразу за элементом с тэго ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());
        // Поиск всех элементов у которых присутствует атрибуб lang
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p[]lang")).size());
        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());
        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ess']")).size());
        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());
        // Поиск всех элементов у которых присутствует аттрибут id с начинающимся словом value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());
        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());
        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим подстроку
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*='o beautiful']")).size());

        //disabled  - элемент, на который нельзя кликнуть
        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());
        // Поиск всех enabled элементов - доступны
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());
        // Поиск всех выборанных элементов
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());
        // Поиск всех элементов c пустым телом
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());
        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());
        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());
        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());
    }

}
