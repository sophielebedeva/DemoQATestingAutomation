import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static constants.Constants.Urls.DEMOQA_HOME_PAGE;

public class MainTest extends BaseTest {

    @Test
    @Description("Тест проверяет работу страниц с текстовыми полями, различными кнопками, корректность открытия/закрытия" +
            "вкладок и окон, оповещений. Валидирует результаты для каждой функциональности")

    public void fullScenarioDemoQATest() {
        basePage.openPage(DEMOQA_HOME_PAGE);
        homePage.goToElementsSection();

        allOptionsPage.goToTextBoxSection();
        textBoxPage.performTextBox();

        allOptionsPage.goToButtonsSection();
        buttonsPage.performButtonsFunctionality();

        allOptionsPage.goToAlertsFramesWindowsSection();
        allOptionsPage.goToBrowserWindowSection();
        browserWindowsPage.performTabWindowOperations();

        allOptionsPage.goToAlertsSection();
        alertsPage.performAlertsFunctionality();

    }
}
