package demonqa.pages;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationUserPage {
   public void openRegisterPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").$(byText("Student Registration Form")).shouldBe(visible);
    }
    public void setFirstName(String value) {
        $("#firstName").setValue(value);

    }
    public void setLastName(String value) {
        $("#lastName").setValue(value);

    }
    public void setUserEmail(String value) {
        $("#userEmail").setValue(value);

    }
    public void setUserGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
    }
    public void setUserNumber(String value) {
        $("#userNumber").setValue(value);
    }
    public void setUserSubject(String value) {
       $("#subjectsInput").setValue(value).pressEnter();

    }
    public void setUserHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
    }
    public void setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
    }
    public void uploadUserPhoto(String filename) {
        $("#uploadPicture").uploadFromClasspath(filename);
    }


    public void setStateAndCity(String state,String city) {
        $("#stateCity-wrapper #react-select-3-input").setValue(state).pressEnter();
        $("#stateCity-wrapper #react-select-4-input").setValue(city).pressEnter();
    }


}
