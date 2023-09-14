package pages;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Set;

public class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }
    By newTabButton = By.cssSelector("#tabButton");
    By newWindowButton = By.cssSelector("#windowButton");

    @Step("Открывает и закрывает новую вкладку, открывает и закрывает новое окно")
    @Story("Проверка открытия/закрытия вкладок и окон")
    public void performTabWindowOperations() {
        openNewTab();
        closeNewTab();
        openNewWindow();
        closeNewWindow();
    }
    public void openNewTab() {
        waitForClickable(driver.findElement(newTabButton));
    }
    public void closeNewTab() {
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        driver.close();
        driver.switchTo().window(handles.get(0));
    }

    public void openNewWindow() {
        waitForClickable(driver.findElement(newWindowButton));
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
