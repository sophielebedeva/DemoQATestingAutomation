package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;
    protected JavascriptExecutor jsexecutor;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.jsexecutor = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void waitForClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public WebDriverWait waitExplicitly(){
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
    }

    public void scrollDown() {
        jsexecutor.executeScript("window.scrollBy(0,250)");
    }

}

