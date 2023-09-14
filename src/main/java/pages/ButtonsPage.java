package pages;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    By simpleClickButton = By.xpath("(//button[normalize-space()='Click Me'])");
    By rightClickButton = By.xpath("(//button[normalize-space()='Right Click Me'])");
    By doubleClickButton = By.cssSelector("#doubleClickBtn");
    By clickMessage = By.cssSelector("#dynamicClickMessage");
    By rightClickMessage = By.cssSelector("#rightClickMessage");
    By doubleClickMessage = By.cssSelector("#doubleClickMessage");

    String messageForSimpleClick = "You have done a dynamic click";
    String messageForRightClick = "You have done a right click";
    String messageForDoubleClick = "You have done a double click";

    @Step("Проверяет работу кнопок: совершает простой клик, клик правой кнопкой мыши, двойной клик," +
            " валидирует все результаты")
    @Story("Проверка разных видов кликов")
    public void performButtonsFunctionality() {
        simpleClickAction();
        validateSimpleClick();
        rightClickAction();
        validateRightClick();
        doubleClickAction();
        validateDoubleClick();

    }

    public void simpleClickAction() {
        waitForClickable(driver.findElement(simpleClickButton));
    }

    public void rightClickAction() {
        actions.contextClick(driver.findElement(rightClickButton)).build().perform();
    }

    public void doubleClickAction() {
        actions.doubleClick(driver.findElement(doubleClickButton)).build().perform();
    }

    public void validateSimpleClick() {
        Assert.assertEquals(driver.findElement(clickMessage).getText(), messageForSimpleClick);
    }

    public void validateRightClick() {
        Assert.assertEquals(driver.findElement(rightClickMessage).getText(), messageForRightClick);
    }

    public void validateDoubleClick() {
        Assert.assertEquals(driver.findElement(doubleClickMessage).getText(), messageForDoubleClick);
    }

}

