package selenide.test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {

    @Test
    public void findSoftAssertions() {
        open("https://github.com/selenide/selenide");

        $$("[class*= UnderlineNav] li").findBy(text("Wiki")).click();
        $(".markdown-body h1").shouldHave(text("Welcome to the selenide wiki!"));
        $$(".markdown-body li a").findBy(text("Soft assertions")).shouldBe(visible);
        $$(".markdown-body li a").findBy(text("Soft assertions")).click();
        //выбран поиск по id блока, тк скорее в блоке с таким id будет искомый сниппет
        $("#user-content-3-using-junit5-extend-test-class").parent()
                .shouldHave(text("3. Using JUnit5 extend test class:"));

    }
}
