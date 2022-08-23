package demonqa.tests;

import com.github.javafaker.Faker;
import demonqa.pages.RegistrationUserPage;
import demonqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static java.lang.String.format;

public class RegisterUserTest extends TestBase {
    RegistrationUserPage registrationUserPage = new RegistrationUserPage();

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
    void registerUser() {
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

    }
}
