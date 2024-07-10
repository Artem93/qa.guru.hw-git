package steps;

import io.qameta.allure.Step;
import pages.GitRepoPages;
import tests.GitRepoTestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GitRepoSteps extends GitRepoTestBase {

    @Step("Открытие страницы GutHub")
    public GitRepoSteps openRepo() {
        open("");
        return this;
    }

    @Step("Переход в раздел Issues")
    public GitRepoSteps clickOnIssueInHeader() {
        GitRepoPages.issueTab.click();
        return this;
    }

    @Step("Проверка issue")
    public GitRepoSteps checkIssueByTextAndId(String text, Integer id) {
        GitRepoPages.issueWithId(id).shouldHave(text(text));
        return this;
    }
}
