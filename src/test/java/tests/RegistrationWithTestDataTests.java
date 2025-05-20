package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static tests.TestData.*;

public class RegistrationWithTestDataTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("en-US"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userPhone = faker.phoneNumber().cellPhone();
    String userAddress = faker.address().streetAddress();

    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userPhone)
                .setDateOfBirth("3", "September", "2010")
                .setSubjectsInput(userSubjects)
                .setHobbiesWrapper(userHobbies)
                .setCurrentAddress(userAddress)
                .setPicture("img.png")
                .setState()
                .setStateCityWrapper(userState)
                .setCity()
                .setStateCityWrapper(userCity)
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userPhone)
                .checkResults("Date of Birth", "03 September,2010")
                .checkResults("Subjects", userSubjects)
                .checkResults("Hobbies", userHobbies)
                .checkResults("Picture", "img.png")
                .checkResults("Address", userAddress)
                .checkResults("State and City", userState + " " + userCity);

    }

    @Test
    void minDataTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("M")
                .setEmail("myemail@mail.com")
                .setGender("Male")
                .setUserNumber("7999111339")
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", "Alex M")
                .checkResults("Student Email", "myemail@mail.com")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "7999111339");
    }

    @Test
    void negativeDataTest() {
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

