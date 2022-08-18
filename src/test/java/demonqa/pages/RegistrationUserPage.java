package demonqa.pages;

import com.codeborne.selenide.SelenideElement;
import demonqa.pages.components.CalendarComponent;
import demonqa.pages.components.ModalResultComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationUserPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ModalResultComponent modalResultComponent = new ModalResultComponent();


    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userSubjectInput = $("#subjectsInput"),
            userHobbyInput = $("#hobbiesWrapper"),
            userCurrentAddressInput = $("#currentAddress"),
            uploadUserPhotoInput = $("#uploadPicture"),
            userStateInput = $("#stateCity-wrapper #react-select-3-input"),
            userCityInput = $("#stateCity-wrapper #react-select-4-input");


    public RegistrationUserPage openRegisterPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").$(byText("Student Registration Form")).shouldBe(visible);
        return this;
    }

    public RegistrationUserPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationUserPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationUserPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    public RegistrationUserPage setUserGender(String value) {
        userGenderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationUserPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationUserPage setUserSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();
        return this;

    }

    public RegistrationUserPage setUserHobby(String value) {
        userHobbyInput.$(byText(value)).click();
        return this;
    }

    public RegistrationUserPage setCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
        return this;
    }

    public RegistrationUserPage uploadUserPhoto(String filename) {
        uploadUserPhotoInput.uploadFromClasspath(filename);
        return this;
    }


    public RegistrationUserPage setStateAndCity(String state, String city) {
        userStateInput.setValue(state).pressEnter();
        userCityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationUserPage clickConfirmButton() {
        $("#userForm #submit").click();

        return this;
    }

    public RegistrationUserPage setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationUserPage checkModalResultVisible() {
        modalResultComponent.isVisible();
        return this;
    }

    public RegistrationUserPage checkResult(String key, String value) {
        modalResultComponent.checkResult(key, value);
        return this;
    }


}
