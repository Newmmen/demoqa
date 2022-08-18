package demonqa.tests;

import com.codeborne.selenide.Configuration;
import demonqa.pages.RegistrationUserPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegisterUserTest {
    RegistrationUserPage registrationUserPage = new RegistrationUserPage();

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void registerUser() {
        registrationUserPage.openRegisterPage()
                .setFirstName("Gosling")
                .setLastName("Ryan")
                .setUserEmail("hellomyprepod@gmail.com")
                .setUserGender("Male")
                .setUserNumber("1234567895")
                .setUserSubject("Math")
                .setUserHobby("Sports")
                .setStateAndCity("NCR", "Delhi")
                .setCurrentAddress("Lenin st. b.12 a.7")
                .uploadUserPhoto("Photo.jpg")
                .setBirthDate("1996", "December", "20")
                .clickConfirmButton();

        registrationUserPage.checkModalResultVisible()
                .checkResult("Student Name", "Gosling Ryan")
                .checkResult("Student Email", "hellomyprepod@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567895")
                .checkResult("Date of Birth", "20 December,1996")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Photo.jpg")
                .checkResult("Address", "Lenin st. b.12 a.7")
                .checkResult("State and City", "NCR Delhi");

    }
}
