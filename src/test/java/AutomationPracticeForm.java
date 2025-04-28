import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1425x691";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;

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
    }
}
