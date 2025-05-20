package tests;

import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    public static void main(String[] args) {
        System.out.println(firstName);
        System.out.println(userGender);
        System.out.println(userSubjects);
        System.out.println(userHobbies);

    }

    public static String
            firstName = "Alex",
            lastName = "May",
            userEmail = "myemail",
            userGender = getRandomGender(),
            userPhone = "79991113399",
            userSubjects = getRandomSubject(),
            userHobbies = getRandomHobbies();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }
    public static String getRandomSubject() {
        String[] subjects = {"Eng", "Che", "Comm", "Eco", "Soc"};
        return getRandomItemFromArray(subjects);
    }
    public static String getRandomHobbies() {
        String[] hobbies = {"Reading", "Sports", "Music"};
        return getRandomItemFromArray(hobbies);
    }




}
