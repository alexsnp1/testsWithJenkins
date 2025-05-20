package tests;

public class TestData {
        public static String
                firstName = "Alex",
                lastName = "May",
                userEmail = "email@mail.com",
                userGender = {"Male", "Female", "Other"},
                userPhone = "79991113399",
                lastName = "May",
                lastName = "May",
                lastName = "May",
                lastName = "May",

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray (genders);
    }
    public static String getRandomItemFromArray (String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
}
