package com;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Human");
        $("#lastName").setValue("Humanov");
        $("#userEmail").setValue("hum@nov.com");
        $("[for = gender-radio-3]").click();
        $("#dateOfBirthInput").click();
        $("#userNumber").setValue("9080706050");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2003");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("[for = hobbies-checkbox-1]").click();
        $("[for = hobbies-checkbox-2]").click();
        $("[for = hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/mem.jpg"));
        $("#currentAddress").setValue("Some address 1");
        $("#state .css-1wa3eu0-placeholder").click();
        $("#react-select-3-option-1").click();
        $("#city .css-1wa3eu0-placeholder").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Human Humanov"));
        $(".table-responsive").shouldHave(text("hum@nov.com"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("9080706050"));
        $(".table-responsive").shouldHave(text("13 March,2003"));
        $(".table-responsive").shouldHave(text("Biology"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("mem.jpg"));
        $(".table-responsive").shouldHave(text("Some address 1"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Lucknow"));


    }

}