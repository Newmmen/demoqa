package demonqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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
        $("#userNumber").setValue("547457");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for=gender-radio-1]").click();
        $("[for=hobbies-checkbox-1]").click();
        $("#currentAddress").setValue("Lenin st. b.12 a.7");
        int f =1;






    }
}
