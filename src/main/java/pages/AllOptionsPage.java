package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllOptionsPage extends BasePage {
    public AllOptionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-0']")
    WebElement textBoxButton;
    @FindBy(xpath = "(//div[contains(@class,'header-wrapper')])[3]")
    WebElement alertsFramesWindowsButton;
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-0']")
    WebElement browserWindowsButton;
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-1']")
    WebElement alertsButton;
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-4']")
    WebElement buttonsButton;
    @FindBy(xpath = "(//div[contains(@class,'header-wrapper')])[1]")
    WebElement elementsButton;

    public void goToTextBoxSection() {
        textBoxButton.click();
    }

    public void goToButtonsSection() {
        buttonsButton.click();
    }

    public void goToAlertsFramesWindowsSection() {
        waitForClickable(elementsButton);
        scrollDown();
        waitForClickable(alertsFramesWindowsButton);
    }

    public void goToBrowserWindowSection() {
        waitForClickable(browserWindowsButton);
    }

    public void goToAlertsSection(){
        scrollDown();
        alertsButton.click();
    }

}
