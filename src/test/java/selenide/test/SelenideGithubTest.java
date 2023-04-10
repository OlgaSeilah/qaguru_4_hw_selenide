package selenide.test;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {

    @Test
    public void findSoftAssertions() {
        Configuration.browserSize = "1920x1080";

        open("https://github.com/selenide/selenide");

        $$("[class*= UnderlineNav] li").findBy(text("Wiki")).click();
        $(".markdown-body h1").shouldHave(text("Welcome to the selenide wiki!"));
        $(byText("Show 2 more pages…")).click();
        $$(".Box-row a").findBy(text("SoftAssertions")).scrollIntoView(false).shouldBe(visible);
        $$(".Box-row a").findBy(text("SoftAssertions")).click();
        //выбран поиск по id блока, тк скорее в блоке с таким id будет искомый сниппет
        $("#user-content-3-using-junit5-extend-test-class").parent()
                .shouldHave(text("3. Using JUnit5 extend test class:"));

    }
}
