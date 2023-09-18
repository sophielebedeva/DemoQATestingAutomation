package pages;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//button[normalize-space()='Click Me'])")
    WebElement simpleClickButton;
    @FindBy(xpath = "(//button[normalize-space()='Right Click Me'])")
    WebElement rightClickButton;
    @FindBy(css ="#doubleClickBtn")
    WebElement doubleClickButton;
    @FindBy(css = "#dynamicClickMessage")
    WebElement clickMessage;
    @FindBy(css = "#rightClickMessage")
    WebElement rightClickMessage;
    @FindBy(css = "#doubleClickMessage")
    WebElement doubleClickMessage;

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
        waitForClickable(simpleClickButton);
    }

    public void rightClickAction() {
        actions.contextClick(rightClickButton).build().perform();
    }

    public void doubleClickAction() {
        actions.doubleClick(doubleClickButton).build().perform();
    }

    public void validateSimpleClick() {
        Assert.assertEquals(clickMessage.getText(), messageForSimpleClick);
    }

    public void validateRightClick() {
        Assert.assertEquals(rightClickMessage.getText(), messageForRightClick);
    }

    public void validateDoubleClick() {
        Assert.assertEquals(doubleClickMessage.getText(), messageForDoubleClick);
    }

}

