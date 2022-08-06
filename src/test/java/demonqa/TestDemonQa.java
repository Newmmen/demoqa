package demonqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class TestDemonQa {

    @BeforeEach
    void openDemonQa(){
        open("https://demoqa.com/automation-practice-form");


    }
    @Test
    void registerUser() {
        $("#firstName").setValue("Gosling");
        $("#lastName").setValue("Ryan");
        $("#userEmail").setValue("hellomyprepod@gmail.com");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select [value='1996']").click();
        $(".react-datepicker__month-select > option").click();
        $(".react-datepicker__week .react-datepicker__day--021").click();
        $("#userNumber").setValue("5474575555");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for=gender-radio-1]").click();
        $("[for=hobbies-checkbox-1]").click();
        $("#currentAddress").setValue("Lenin st. b.12 a.7");
        $("#uploadPicture").uploadFile(new File("src/test/resources/Photo.jpg"));
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter().pressEnter();


        $$("tbody tr").filterBy(text("Student Name")).shouldHave(texts("Gosling Ryan"));
        $$("tbody tr").filterBy(text("Student Email")).shouldHave(texts("hellomyprepod@gmail.com"));
        $$("tbody tr").filterBy(text("Gender")).shouldHave(texts("Male"));
        $$("tbody tr").filterBy(text("Mobile")).shouldHave(texts("5474575555"));
        $$("tbody tr").filterBy(text("Date of Birth")).shouldHave(texts("21 January,1996"));
        $$("tbody tr").filterBy(text("Subjects")).shouldHave(texts("Maths"));
        $$("tbody tr").filterBy(text("Hobbies")).shouldHave(texts("Sports"));
        $$("tbody tr").filterBy(text("Picture")).shouldHave(texts("Photo.jpg"));
        $$("tbody tr").filterBy(text("Address")).shouldHave(texts("Lenin st. b.12 a.7 "));
        $$("tbody tr").filterBy(text("State and City")).shouldHave(texts("NCR Delhi"));







    }
}
