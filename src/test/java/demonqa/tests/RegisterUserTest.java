package demonqa.tests;

import com.codeborne.selenide.Configuration;
import demonqa.pages.RegistrationUserPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegisterUserTest {
    RegistrationUserPage registrationUserPage = new RegistrationUserPage();

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void registerUser() {
        registrationUserPage.openRegisterPage().setFirstName("Gosling");
        registrationUserPage.setLastName("Ryan");
        registrationUserPage.setUserEmail("hellomyprepod@gmail.com");
        registrationUserPage.setUserGender("Male");
        registrationUserPage.setUserNumber("1234567895");
        registrationUserPage.setUserSubject("Math");
        registrationUserPage.setUserHobby("Sports");
        registrationUserPage.setStateAndCity("NCR","Delhi");
        registrationUserPage.setCurrentAddress("Lenin st. b.12 a.7");
        registrationUserPage.uploadUserPhoto("Photo.jpg");



        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("December")).click();
        $(".react-datepicker__year-select").$(byText("1996")).click();
        $(".react-datepicker__month").$(byText("20")).click();



        $$("tbody tr").filterBy(text("Student Name")).shouldHave(texts("Gosling Ryan"));
        $$("tbody tr").filterBy(text("Student Email")).shouldHave(texts("hellomyprepod@gmail.com"));
        $$("tbody tr").filterBy(text("Gender")).shouldHave(texts("Male"));
        $$("tbody tr").filterBy(text("Mobile")).shouldHave(texts("1234567895"));
        $$("tbody tr").filterBy(text("Date of Birth")).shouldHave(texts("20 December,1996"));
        $$("tbody tr").filterBy(text("Subjects")).shouldHave(texts("Maths"));
        $$("tbody tr").filterBy(text("Hobbies")).shouldHave(texts("Sports"));
        $$("tbody tr").filterBy(text("Picture")).shouldHave(texts("Photo.jpg"));
        $$("tbody tr").filterBy(text("Address")).shouldHave(texts("Lenin st. b.12 a.7 "));
        $$("tbody tr").filterBy(text("State and City")).shouldHave(texts("NCR Delhi"));
    }
}
