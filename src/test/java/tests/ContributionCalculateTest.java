package tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("web")
@Feature("Slider test in contribution calculator")
public class ContributionCalculateTest extends TestBase {
    SliderTest slider = new SliderTest();
    Faker faker = new Faker();

    @Test
    @DisplayName("Check income from contribution")
    void percentContTest() {
        step("Open main page", () -> {
                    open("");
                    $("#tab-32910").shouldHave(Condition.text("Рассчитайте свой кредит")).scrollTo();
                });
        step("Set value in contribution calculator", () -> {
                    $(".Slider__SliderBox-credit-calculator__dxxjdy-2").shouldBe(visible);
                    $(".Slider__Runner-credit-calculator__dxxjdy-5").hover();
                    slider.slider();
                });
        step("Set contribution time", () -> {
                    $(".ListTerms__Box-credit-calculator__sc-18rkehz-1").shouldBe(visible);
                    $(byText("5 лет")).click();
                });
        step("Send request button", () -> {
                    $(".main-pic__btn-wrap .scroll-to-service").click();
                    switchTo().window(1);
                });
        step("Input phone number", () -> {
                    $(".top-block #step_1").shouldHave(text("Для получения кредита введите номер телефона"));
                    $("#OpenBkithreestepsForm_mobile").val(faker.phoneNumber().subscriberNumber(10));
                });
        step("Click submit button", () -> {
            $(byName("btn_submit_step_1")).click();
        });

    }
    @Test
    @Story("Added story test")
    @DisplayName("Optional test for story")
    void WithStoryTest() {
        open("");
        $(".horizont__title").shouldBe(visible);

    }
}
