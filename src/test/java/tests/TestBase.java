package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    //String firstNameLocator = "first_name";



@BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; //при долгой загрузке не падает тест
        Configuration.holdBrowserOpen = true; //не закрывается браузер
    }
}
