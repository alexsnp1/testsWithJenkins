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

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("M");
        $("#userEmail").setValue("myemail@mail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("79991113399");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-container]").$("[aria-label='Choose Monday, April 14th, 2025']").click();
        $("#subjectsInput").setValue("Eng");
        $("[class='subjects-auto-complete__menu css-26l3qy-menu']").$("#react-select-2-option-0").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("#currentAddress").setValue("Address 1");
        File file = new File("src/test/resources/img.png");
        $("#uploadPicture").uploadFile(file);
        $("#uploadPicture").uploadFromClasspath("img.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $("[class='modal-content']").shouldHave(text("Student Name Alex M"));
        $("[class='modal-content']").shouldHave(text("Student Email myemail@mail.com"));
        $("[class='modal-content']").shouldHave(text("Gender Male"));
        $("[class='modal-content']").shouldHave(text("Mobile 7999111339"));
        $("[class='modal-content']").shouldHave(text("Date of Birth	14 April,2025"));
        $("[class='modal-content']").shouldHave(text("Subjects English"));
        $("[class='modal-content']").shouldHave(text("Hobbies Reading"));
        $("[class='modal-content']").shouldHave(text("Picture img.png"));
        $("[class='modal-content']").shouldHave(text("Address Address 1"));
        $("[class='modal-content']").shouldHave(text("State and City NCR Noida"));


    }
}
