package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQAHomePage extends BasePage {
    public DemoQAHomePage(WebDriver driver) {
        super(driver);
    }

    By elementsButton = By.xpath("//div[@class='category-cards']/div[1]/div[1]");

    public WebElement goToElementsSection() {
        scrollDown();
        WebElement element = driver.findElement(elementsButton);
        jsexecutor.executeScript("arguments[0].click();", element);
        return element;
    }

}
