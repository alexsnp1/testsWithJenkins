package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage().setFirstName("Alex")
                .setLastName("M")
                .setEmail("myemail@mail.com")
                .setGender("Male")
                .setUserNumber("79991113399")
                .setDateOfBirth("3", "September", "2010")
                .setSubjectsInput("Eng")
                .setHobbiesWrapper("Reading")
                .setCurrentAddress("Address 1")
                .setPicture("img.png")
                .setState()
                .setStateCityWrapper("NCR")
                .setCity()
                .setStateCityWrapper("Noida")
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", "Alex M")
                .checkResults("Student Email", "myemail@mail.com")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "7999111339")
                .checkResults("Date of Birth", "03 September,2010")
                .checkResults("Subjects", "English")
                .checkResults("Hobbies", "Reading")
                .checkResults("Picture", "img.png")
                .checkResults("Address", "Address 1")
                .checkResults("State and City", "NCR Noida");

    }

    @Test
    void minDataTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("M")
                .setEmail("myemail@mail.com")
                .setGender("Male")
                .setUserNumber("79991113399")
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", "Alex M")
                .checkResults("Student Email", "myemail@mail.com")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "7999111339");
    }

    @Test
    void NegativeDataTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("M")
                .setEmail("myemail")
                .setGender("Male")
                .setUserNumber("my number")
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", "Alex M")
                .checkResults("Student Email", "myemail")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "my number");
    }
}

