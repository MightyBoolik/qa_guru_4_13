package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Main page tests")
public class MainPageTest extends TestBase {
    Faker faker = new Faker();

    @Test
    @DisplayName("Main page should be loaded")
    void PageLoadedTest() {
        step("Open main page", () -> {
            open("");
            $(".horizont__title").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Internet-bank")
    void InternetBankButtonTest() {
        step("Open main page", () -> {
                    open("");
                    sleep(5000);
                });
        step("Internet-bank button click", () -> {
                    $$("div.g-header_i .btn-internet-bank").find(text("Интернет-банк")).click();
                });
        step("Google play service button click", () -> {
            $("div.popup-2__inner").shouldBe(visible);
            $(byText("Google Play")).click();
        });


    }

    @Test
    @DisplayName("Test support chat")
    void phoneButtonTest() {
        step("Open main page", () -> {
                    open("");
                    $("div.g-main").shouldBe(visible);
                });
        step("Click phone button", () -> {
                    $("div.js-open-btn").click();
                });
        step("Request a call button", () -> {
                    $(byText("Заказать звонок")).click();
                });
        step("Input phone number", () -> {
            $("#call-api-form .js-form-tel").val(faker.phoneNumber().subscriberNumber(9)).click();
        });

    }
    @Test
    @DisplayName("Test telegram message button")
    @AllureId("2043")
    void telegramButtonTest() {
        step("Open main page", () -> {
            open("");
            $("div.g-main").shouldBe(visible);
        });
        step("Click phone button", () -> {
            $("div.js-open-btn").click();
        });
        step("Click telegram button", () -> {
            $(byText("Telegram")).click();
        });

    }

}

