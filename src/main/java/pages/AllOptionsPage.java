package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AllOptionsPage extends BasePage {
    public AllOptionsPage(WebDriver driver) {
        super(driver);
    }

    By textBoxButton = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
    By alertsFramesWindowsButton = By.xpath("(//div[contains(@class,'header-wrapper')])[3]");
    By browserWindowsButton = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
    By alertsButton = By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']");
    By buttonsButton = By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']");
    By elementsButton = By.xpath("(//div[contains(@class,'header-wrapper')])[1]");

    public void goToTextBoxSection() {
        driver.findElement(textBoxButton).click();
    }

    public void goToButtonsSection() {
        driver.findElement(buttonsButton).click();
    }

    public void goToAlertsFramesWindowsSection() {
        waitForClickable(driver.findElement(elementsButton));
        scrollDown();
        waitForClickable(driver.findElement(alertsFramesWindowsButton));
    }

    public void goToBrowserWindowSection() {
        waitForClickable(driver.findElement(browserWindowsButton));
    }

    public void goToAlertsSection(){
        scrollDown();
        driver.findElement(alertsButton).click();
    }

}
