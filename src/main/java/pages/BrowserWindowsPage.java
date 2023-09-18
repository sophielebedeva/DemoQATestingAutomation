package pages;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Set;

public class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#tabButton")
    WebElement newTabButton;
    @FindBy(css = "#windowButton")
    WebElement newWindowButton;

    @Step("Открывает и закрывает новую вкладку, открывает и закрывает новое окно")
    @Story("Проверка открытия/закрытия вкладок и окон")
    public void performTabWindowOperations() {
        openNewTab();
        closeNewTab();
        openNewWindow();
        closeNewWindow();
    }
    public void openNewTab() {
        waitForClickable(newTabButton);
    }
    public void closeNewTab() {
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        driver.close();
        driver.switchTo().window(handles.get(0));
    }

    public void openNewWindow() {
        waitForClickable(newWindowButton);
    }

    public void closeNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.close();
        driver.switchTo().window((String) windowHandles.toArray()[0]);
    }

}
