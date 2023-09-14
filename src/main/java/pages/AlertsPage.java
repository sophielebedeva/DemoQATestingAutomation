package pages;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    By toSeeAlertButton = By.cssSelector("#alertButton");
    By toSeeAlertIn5Seconds = By.cssSelector("#timerAlertButton");
    By toSeeConfirmButton = By.cssSelector("#confirmButton");
    By toSeePromptButton = By.cssSelector("#promtButton");
    By messageConfirmAlert = By.cssSelector("#confirmResult");
    By messagePromptAlert = By.cssSelector("#promptResult");

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
        waitForVisibility(driver.findElement(toSeeAlertButton));
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public void open5secAlert() {
        waitForClickable(driver.findElement(toSeeAlertIn5Seconds));
        waitExplicitly().until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public void openAlertWithConfirm() {
        waitForClickable(driver.findElement(toSeeConfirmButton));
    }

    public void confirmAlert() {
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(messageConfirmAlert).getText(), validMessageConfirmAlert);
        driver.switchTo().defaultContent();
    }

    public void openPromptAlert() {
        scrollDown();
        waitForClickable(driver.findElement(toSeePromptButton));
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(testName);
        alert.accept();
        driver.switchTo().defaultContent();
    }
    public void validatePromptAlert() {
        Assert.assertEquals(driver.findElement(messagePromptAlert).getText(), validPromptMessage);
    }
}
