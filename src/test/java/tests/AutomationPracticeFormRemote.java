package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
//import static jdk.internal.misc.ThreadFlock.open;
//import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class AutomationPracticeFormRemote {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; //при долгой загрузке не падает тест
        Configuration.holdBrowserOpen = true; //не закрывается браузер
    }

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Open form", () -> {
            open("/automation-practice-form");
            //убирает рекламу
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });

        step("Fill form", () -> {
            $("#firstName").setValue("Alex");
            $("#lastName").setValue("M");
            $("#userEmail").setValue("myemail@mail.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("79991113399");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").$(byText("September")).click();
            $(".react-datepicker__year-select").$(byText("2010")).click();
            $(".react-datepicker__month").$(byText("3")).click();
            $("#subjectsInput").setValue("Eng").pressEnter();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#currentAddress").setValue("Address 1");
            $("#uploadPicture").uploadFromClasspath("img.png");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Noida")).click();
            $("#submit").click();
        });

        step("Check form", () -> {
            $(".modal-content").shouldHave(text("Student Name Alex M"));
            $(".modal-content").shouldHave(text("Student Email myemail@mail.com"));
            $(".modal-content").shouldHave(text("Gender Male"));
            $(".modal-content").shouldHave(text("Mobile 7999111339"));
            $(".modal-content").shouldHave(text("Date of Birth 03 September,2010"));
            $(".modal-content").shouldHave(text("Subjects English"));
            $(".modal-content").shouldHave(text("Hobbies Reading"));
            $(".modal-content").shouldHave(text("Picture img.png"));
            $(".modal-content").shouldHave(text("Address Address 1"));
            $(".modal-content").shouldHave(text("State and City NCR Noida"));
        });
    }
}