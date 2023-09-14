package common;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

import static constants.Constants.TimeOutVariables.IMPLICIT_WAIT;
import static common.Configuration.BROWSERNAME;

public class CommonActions {
    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch (BROWSERNAME) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> Assert.fail("Некорректное имя браузера " + BROWSERNAME);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        return driver;
    }
}
