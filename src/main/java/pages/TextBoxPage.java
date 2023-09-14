package pages;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    By fullNameForm = By.cssSelector("#userName");
    By emailForm = By.cssSelector("#userEmail");
    By currentAddressForm = By.xpath("//textarea[@id='currentAddress']");
    By permanentAddressForm = By.xpath("//textarea[@id='permanentAddress']");
    By submitButton = By.cssSelector("#submit");
    By submittedInfoBox = By.cssSelector(".border.col-md-12.col-sm-12");

    Map<String, String> textBoxValues = Map.of("name", "Sophie",
            "email", "email@e.ru",
            "currentAddress", "Pushkin street, 65, apartment 24",
            "permanentAddress", "Lermontov street, 31, apartment 97");


    @Step("Проверяет работу текстового блока: заполняет поля Full Name, Email, Current Address, Permanent address" +
            "сохраняет результат, валидирует отображаемые результаты")
    @Feature("Отправка личных данных")
    public void performTextBox() {
        fillTextBox(textBoxValues);
        submitTextInfo();
        checkFilledInfo(textBoxValues);
    }

    @Description("Заполняет все поля в textBox")
    public void fillTextBox(Map<String, String> values) {
        driver.findElement(fullNameForm).sendKeys(values.get("name"));
        driver.findElement(emailForm).sendKeys(values.get("email"));
        scrollDown();
        driver.findElement(currentAddressForm).sendKeys(values.get("currentAddress"));
        driver.findElement(permanentAddressForm).sendKeys(values.get("permanentAddress"));
        scrollDown();
    }

    @Description("Отправляет заполненную информацию")
    public void submitTextInfo() {
        WebElement submitClickButton = driver.findElement(submitButton);
        waitForClickable(submitClickButton);
    }

    @Description("Проверяет, что введеная информация об имени, фамилии, адресах соответствует отображаемой")
    public void checkFilledInfo(Map<String, String> values) {
        String[] submittedInfo = driver.findElements(submittedInfoBox).get(0).getText().split("\n");
        Map<String, String> valuesFromForm = new HashMap<>();
        valuesFromForm.put("name", submittedInfo[0].split(":")[1]);
        valuesFromForm.put("email", submittedInfo[1].split(":")[1]);
        valuesFromForm.put("currentAddress", submittedInfo[2].split(":")[1]);
        valuesFromForm.put("permanentAddress", submittedInfo[3].split(":")[1]);
        Assert.assertEquals(valuesFromForm, values);
    }

}
