package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @Test
    void softAssertionsShouldHaveJUnit5Code(){
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".f6.Link--muted").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));

        //Откройте страницу SoftAssertions,
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();

        //проверьте что внутри есть пример кода для JUnit5
        var checkedText = """
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """;

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"), text(checkedText));

        sleep(4000);

    }

}



