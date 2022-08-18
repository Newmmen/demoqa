package demonqa.pages.components;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ModalResultComponent {

    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ModalResultComponent isVisible() {
        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;
    }
    public ModalResultComponent checkResult(String key, String value){
        $$("tbody tr").filterBy(text(key)).shouldHave(texts(value));
        return this;
    }

}
