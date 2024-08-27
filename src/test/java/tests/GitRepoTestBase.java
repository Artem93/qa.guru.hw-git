package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.GitRepoPages;

public class GitRepoTestBase {

    public final GitRepoPages gitRepoPages = new GitRepoPages();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com/Artem93/qa.guru.hw-git/issues";
        Configuration.browserSize = "1920x1280";

    }
}
