package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataWithFaker {
    public static Faker faker = new Faker(new Locale("en-US"));

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String userAddress = faker.address().streetAddress();
}
