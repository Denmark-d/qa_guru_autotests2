package ru.Denmark;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormWithComments {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1920x1080";
    }
    @Test 
    void firsttest(){
        System.out.println("First Test");
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
//      firstName
        $("#firstName").setValue("Danny");
//      lastName
        $("#lastName").setValue("Dan");
//      Заполнили email
        $("#userEmail").setValue("Danny@mail.ru");
//      Кликнули на радиобаттон
        $("[for='gender-radio-2']").click();
//      Заполнили номер
        $("#userNumber").setValue("89371703123");
        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        //Subjects
        $("#subjectsInput").setValue("history").pressEnter();
//      Выбор хобби
       //$("[for=hobbies-checkbox-1]").click(); не работает
        $("[for='hobbies-checkbox-1']").click();
        //$("#hobbiesWrapper").$(byText("Sports")).click();
//Select picture
        //("#uploadPicture").uploadFromClasspath("custom");-work
        $("#uploadPicture").uploadFromClasspath("custom/1 .png");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/custom"));-work
// Current Address
        $("#currentAddress").setValue("Наметкина");

//Select State
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        // Select City
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();
        $("#submit").scrollTo().click();
      //проверки
        $(".table table-dark table-striped table-bordered table-hover").isDisplayed();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Danny Dan"),text("Danny@mail.ru"));
        $(".table-responsive").shouldHave(text("8937170312"),text("29 July,1988"),text("history"),
                                                    text("1 .png"),text("Наметкина"),text("Uttar Pradesh Lucknow"));


    }
}
