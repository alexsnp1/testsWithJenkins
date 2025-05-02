import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
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

    }
}
