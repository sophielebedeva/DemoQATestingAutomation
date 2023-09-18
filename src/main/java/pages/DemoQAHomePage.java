package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAHomePage extends BasePage {
    public DemoQAHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[1]/div[1]")
    WebElement elementsButton;

    public void goToElementsSection() {
        scrollDown();
        jsexecutor.executeScript("arguments[0].click();", elementsButton);
    }

}
