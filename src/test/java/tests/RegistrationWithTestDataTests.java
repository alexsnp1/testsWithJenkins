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
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjectsInput(userSubjects)
                .setHobbiesWrapper(userHobbies)
                .setCurrentAddress(userAddress)
                .setPicture(userPicture)
                .setState()
                .setStateCityWrapper(userState)
                .setCity()
                .setStateCityWrapper(userCity)
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userPhone)
                .checkResults("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResults("Subjects", userSubjects)
                .checkResults("Hobbies", userHobbies)
                .checkResults("Picture", userPicture)
                .checkResults("Address", userAddress)
                .checkResults("State and City", userState + " " + userCity);

    }

    @Test
    void minDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userPhone)
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userPhone);
    }

    @Test
    void negativeDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail("myemail")
                .setGender(userGender)
                .setUserNumber("my number")
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", "myemail")
                .checkResults("Gender", userGender)
                .checkResults("Mobile", "my number");
    }
}

