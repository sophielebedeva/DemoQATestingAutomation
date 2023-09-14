import common.CommonActions;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

import static common.Configuration.CLEAR_COOKIES;
import static common.Configuration.KEEP_BROWSER_OPEN;


public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected DemoQAHomePage homePage = new DemoQAHomePage(driver);
    protected TextBoxPage textBoxPage = new TextBoxPage(driver);
    protected AllOptionsPage allOptionsPage = new AllOptionsPage(driver);
    protected ButtonsPage buttonsPage = new ButtonsPage(driver);
    protected AlertsPage alertsPage = new AlertsPage(driver);
    protected BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);


    @BeforeTest
    public void setUpAllure() {
        Allure.setLifecycle(new AllureLifecycle());
    }

    @AfterTest
    public void clearCookies() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterTest
    public void closeBrowser() {
        if (!KEEP_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
