package github;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop(){
        open("https://github.com/");
        $("[name = q]").setValue("selenide").pressEnter();
       // $$("ul.repo-list.li").first().$("a").click();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        sleep(2000);
    }
}
