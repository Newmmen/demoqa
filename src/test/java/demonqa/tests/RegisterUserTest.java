package demonqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import demonqa.pages.RegistrationUserPage;
import demonqa.utils.RandomUtils;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static java.lang.String.format;

public class RegisterUserTest extends TestBase {

    RegistrationUserPage registrationUserPage = new RegistrationUserPage();
    WebHelper webHelper = new WebHelper();

    Faker faker = new Faker(new Locale("EN"));
    RandomUtils randomUtils = new RandomUtils();

    String userFirstName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = "Male",
            userPhoneNumber = faker.phoneNumber().subscriberNumber(10),
            userSubject = "Maths",
            userHobby = "Sports",
            userState = "NCR",
            userCity = "Delhi",
            userCurrentAddress = faker.address().fullAddress(),
            userBirthDateDay = faker.number().numberBetween(1, 30) + "",
            userBirthDateMonth = randomUtils.getRandomMonth(),
            userBirthDateYear = faker.number().numberBetween(1990, 2000) + "",
            userPhotoName = "Photo.jpg";
    String expectedFullName = format("%s %s", userFirstName, userLastName),
            expectedStateAndCity = format("%s %s", userState, userCity),
            expectedBirthDate = format("%s %s,%s", userBirthDateDay, userBirthDateMonth, userBirthDateYear);

    @Test
    @DisplayName("Проверка корректности сохранения даных при регистрации пользователя")

    void registerUser() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationUserPage.openRegisterPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setUserEmail(userEmail)
                .setUserGender(userGender)
                .setUserNumber(userPhoneNumber)
                .setUserSubject(userSubject)
                .setUserHobby(userHobby)
                .setStateAndCity(userState, userCity)
                .setCurrentAddress(userCurrentAddress)
                .uploadUserPhoto(userPhotoName)
                .setBirthDate(userBirthDateYear, userBirthDateMonth, userBirthDateDay)
                .clickConfirmButton();

        registrationUserPage.checkModalResultVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userPhoneNumber)
                .checkResult("Date of Birth", expectedBirthDate)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userHobby)
                .checkResult("Picture", userPhotoName)
                .checkResult("Address", userCurrentAddress)
                .checkResult("State and City", expectedStateAndCity);
        webHelper.takeScreenShot();
        webHelper.addPageSource();

    }
}
