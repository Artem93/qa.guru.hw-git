package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.GitRepoPages;
import steps.GitRepoSteps;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitRepoTests extends GitRepoTestBase {

    @CsvSource(value = {
            "test, 1"
    })
    @ParameterizedTest(name = "Проверка Issue с значением: {0}. Через selenide")
    void checkIssueInHeaderBySelenide(String issueName, Integer issueId) {
        open("");
        GitRepoPages gitRepoPages = new GitRepoPages();
        gitRepoPages
                .clickOnIssueInHeader()
                .checkIssueByTextAndId(issueName, issueId);
    }


    @CsvSource(value = {
            "test, 1"
    })
    @ParameterizedTest(name = "Проверка Issue с значением: {0}. Через степы")
    void checkIssueInHeaderByStep(String issueName, Integer issueId) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открытие страницы GutHub", () -> open(""));
        step("Переход в раздел Issues", gitRepoPages::clickOnIssueInHeader);
        step(String.format("Проверка issue c названием %s и id =%d", issueName, issueId),
                () -> gitRepoPages.checkIssueByTextAndId(issueName, issueId));
    }

    @CsvSource(value = {
            "И ишо одын, 3"
    })
    @ParameterizedTest(name = "Проверка Issue с значением: {0}. Через аннотации")
    void checkIssueInHeaderByAnnotation(String issueName, Integer issueId) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new GitRepoSteps()
                .openRepo()
                .clickOnIssueInHeader()
                .checkIssueByTextAndId(issueName, issueId);
    }
}
