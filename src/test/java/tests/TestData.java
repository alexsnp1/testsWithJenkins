package tests;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    public static void main(String[] args) {
        // System.out.println(firstName);
//        System.out.println(userGender);
//        System.out.println(userSubjects);
//        System.out.println(userHobbies);
//        System.out.println(userState);
//        System.out.println(userCity);
//        System.out.println(userPhone);

    }

    public static String
            userGender = getRandomGender(),
            userPhone = getRandomPhone(),
            userSubjects = getRandomSubject(),
            userHobbies = getRandomHobbies(),
            userState = getRandomState(),
            userCity = getRandomCity(),
            dayOfBirth = getRandomDay(),
            monthOfBirth = getRandomMonth(),
            yearOfBirth = getRandomYear(),
            userPicture = getRandomPicture();


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }

//    public static String getRandomPhone(long min, long max) {
//        long randomNumber = ThreadLocalRandom.current().nextLong(min, max + 1);
//        return String.valueOf(randomNumber);
//    }

    public static String getRandomPhone() {
        //получить телефон такого формата +5 (932) 944 - 92 - 16
//            return String.format("+%s (%s) %s - %s - %s", getRandomInt(1,9), getRandomInt(111,999),
//                    getRandomInt(111,999), getRandomInt(11,99), getRandomInt(11,99)); }
        return String.format("%s%s", getRandomInt(10000,99999), getRandomInt(10000,99999)); }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];

    }

    public static String getRandomDay() {
        int day = ThreadLocalRandom.current().nextInt(1, 31);
        return String.format("%02d", day);
    }
    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(months);
    }
    public static String getRandomYear() {
        int year = ThreadLocalRandom.current().nextInt(1990, 2025);
        return String.valueOf(year);
        }

    public static String getRandomSubject() {
        String[] subjects = {"Eng", "Che", "Comm", "Eco", "Soc"};
        return getRandomItemFromArray(subjects);
    }
    public static String getRandomHobbies() {
        String[] hobbies = {"Reading", "Sports", "Music"};
        return getRandomItemFromArray(hobbies);
    }
    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromArray(states);
    }
    public static String getRandomCity() {
        String[] cities = {};
        if (userState.equals("NCR")) {
            cities = new String[]{"Delhi", "Gurgaon", "Noida"};
        } else if (userState.equals("Uttar Pradesh")) {
            cities = new String[]{"Agra", "Lucknow", "Merrut"};
        } else if (userState.equals("Haryana")) {
            cities = new String[]{"Karnal", "Panipat"};
        } else if (userState.equals("Rajasthan")) {
            cities = new String[]{"Jaipur", "Jaiselmer"};
        }

        return getRandomItemFromArray(cities);
    }
    public static String getRandomPicture() {
        String[] pictures = {"img.png", "img2.jpeg", "img3.jpg"};
        return getRandomItemFromArray(pictures);
    }




}
