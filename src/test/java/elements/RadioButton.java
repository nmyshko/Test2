package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<UIElement> uiElementList;
    // Продумать механизм поиска этого элемента
    // Поиск по name
    public RadioButton(WebDriver driver, String attributeNameValue) {
        uiElementList = new ArrayList<>();

        for(WebElement webElement : driver.findElements(By.name(attributeNameValue))) { //из всех элементов добавить этот
            uiElementList.add(new UIElement(driver, webElement));
        }
    }

    // Добавить методы для работы с ним
    // selectByValue, selectByText, selectByIndex

    public void selectByIndex(int index) {
        uiElementList.get(index).click();
    }

    // Проверить что поиск и методы работют на всех похожих элементах сайта

}
