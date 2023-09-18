package pages;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#alertButton")
    WebElement toSeeAlertButton;
    @FindBy(css = "#timerAlertButton")
    WebElement toSeeAlertIn5Seconds;
    @FindBy(css = "#confirmButton")
    WebElement toSeeConfirmButton;
    @FindBy(css = "#promtButton")
    WebElement toSeePromptButton;
    @FindBy(css = "#confirmResult")
    WebElement messageConfirmAlert;
    @FindBy(css = "#promptResult")
    WebElement messagePromptAlert;

    String validMessageConfirmAlert = "You selected Ok";
    String testName = "Test name";
    String validPromptMessage = "You entered " + testName;

    @Step("Открывает обычный alert, alert с задержкой в 5 секунд, alert со строкой ввода, " +
            "вводит текст и валидирует его после принятия alert")
    @Story("Проверка различных оповещений")
    public void performAlertsFunctionality() {
        openAlert();
        open5secAlert();
        openAlertWithConfirm();
        confirmAlert();
        openPromptAlert();
        validatePromptAlert();
    }

    public void openAlert() {
        waitForVisibility(toSeeAlertButton);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public void open5secAlert() {
        waitForClickable(toSeeAlertIn5Seconds);
        waitExplicitly().until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public void openAlertWithConfirm() {
        waitForClickable(toSeeConfirmButton);
    }

    public void confirmAlert() {
        driver.switchTo().alert().accept();
        Assert.assertEquals(messageConfirmAlert.getText(), validMessageConfirmAlert);
        driver.switchTo().defaultContent();
    }

    public void openPromptAlert() {
        scrollDown();
        waitForClickable(toSeePromptButton);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(testName);
        alert.accept();
        driver.switchTo().defaultContent();
    }

    public void validatePromptAlert() {
        Assert.assertEquals(messagePromptAlert.getText(), validPromptMessage);
    }
}
