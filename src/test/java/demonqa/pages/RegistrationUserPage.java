package demonqa.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationUserPage {


    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput =  $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userSubjectInput =  $("#subjectsInput"),
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
    public void setFirstName(String value) {
        firstNameInput.setValue(value);

    }
    public void setLastName(String value) {
        lastNameInput.setValue(value);

    }
    public void setUserEmail(String value) {
        userEmailInput.setValue(value);

    }
    public void setUserGender(String value) {
        userGenderInput.$(byText(value)).click();
    }
    public void setUserNumber(String value) {
        userNumberInput.setValue(value);
    }
    public void setUserSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();

    }
    public void setUserHobby(String value) {
        userHobbyInput.$(byText(value)).click();
    }
    public void setCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
    }
    public void uploadUserPhoto(String filename) {
        uploadUserPhotoInput.uploadFromClasspath(filename);
    }


    public void setStateAndCity(String state,String city) {
        userStateInput.setValue(state).pressEnter();
        userCityInput.setValue(city).pressEnter();
    }


}
