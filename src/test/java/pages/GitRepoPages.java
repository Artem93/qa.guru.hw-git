package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GitRepoPages {
    public static final SelenideElement issueTab = $("#issues-tab");
    public static SelenideElement issueWithId(Integer id) {
        return $(String.format("[href='/Artem93/qa.guru.hw-git/issues/%s']", id));
    }

    public GitRepoPages clickOnIssueInHeader() {
        issueTab.click();
        return this;
    }

    public GitRepoPages checkIssueByTextAndId(String text, Integer id) {
        issueWithId(id).shouldHave(text(text));
        return this;
    }
}
