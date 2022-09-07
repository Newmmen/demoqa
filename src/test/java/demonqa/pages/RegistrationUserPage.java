package demonqa.pages;

import com.codeborne.selenide.SelenideElement;
import demonqa.pages.components.CalendarComponent;
import demonqa.pages.components.ModalResultComponent;
import demonqa.tests.WebHelper;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationUserPage {
    WebHelper webHelper = new WebHelper();

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


    @Step("Открывается форма регистрации")
    public RegistrationUserPage openRegisterPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").$(byText("Student Registration Form")).shouldBe(visible);
        webHelper.removeBanner();
        return this;
    }

    @Step("Заполняется имя пользователя")
    public RegistrationUserPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполняется фамилия пользователя")
    public RegistrationUserPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполняется email пользователя")
    public RegistrationUserPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    @Step("Заполняется пол пользователя")
    public RegistrationUserPage setUserGender(String value) {
        userGenderInput.$(byText(value)).click();
        return this;
    }

    @Step("Заполняется номер телефона пользователя")
    public RegistrationUserPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Заполняется учебный предмет пользователя")
    public RegistrationUserPage setUserSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();
        return this;

    }

    @Step("Заполняется хобби пользователя")
    public RegistrationUserPage setUserHobby(String value) {
        userHobbyInput.$(byText(value)).click();
        return this;
    }

    @Step("Заполняется текущий адрес пользователя")
    public RegistrationUserPage setCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
        return this;
    }

    @Step("Загружается фото пользователя")
    public RegistrationUserPage uploadUserPhoto(String filename) {
        uploadUserPhotoInput.uploadFromClasspath(filename);
        return this;
    }

    @Step("Заполняется штат и город пользователя")
    public RegistrationUserPage setStateAndCity(String state, String city) {
        userStateInput.setValue(state).pressEnter();
        userCityInput.setValue(city).pressEnter();
        return this;
    }

    @Step("Подтверждаем данные нажатием 'Confirm'")
    public RegistrationUserPage clickConfirmButton() {
        $("#userForm #submit").click();

        return this;
    }

    @Step("Заполняется день рождения пользователя")
    public RegistrationUserPage setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    @Step("Проверяем открытие окна с данными пользователя")
    public RegistrationUserPage checkModalResultVisible() {
        modalResultComponent.isVisible();
        return this;
    }

    @Step("Проверяем сохранение введенного {0} на сайте")
    public RegistrationUserPage checkResult(String key, String value) {
        modalResultComponent.checkResult(key, value);
        return this;
    }


}
