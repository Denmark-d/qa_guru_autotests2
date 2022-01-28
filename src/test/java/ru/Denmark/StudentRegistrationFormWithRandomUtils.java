package ru.Denmark;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.Denmark.utils.RandomUtils.getRandomString;

public class StudentRegistrationFormWithRandomUtils {

    String firstName = getRandomString(12);

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1920x1080";
    }
    @Test
    void firstTest(){
        System.out.println("First Test");
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue("Dan");
        $("#userEmail").setValue("Danny@mail.ru");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("89371703123");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("history").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("custom/1 .png");
        $("#currentAddress").setValue("Наметкина");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();
        $("#submit").scrollTo().click();
        $(".table table-dark table-striped table-bordered table-hover").isDisplayed();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName +" Dan"),text("Danny@mail.ru"));
        $(".table-responsive").shouldHave(text("8937170312"),text("29 July,1988"),text("history"),
                                                    text("1 .png"),text("Наметкина"),text("Uttar Pradesh Lucknow"));


    }
}
