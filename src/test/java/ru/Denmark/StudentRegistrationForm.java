package ru.Denmark;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.temporal.JulianFields;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1920x1080";
    }
    @Test
    void firsttest(){
        System.out.println("First Test");
        open("https://demoqa.com/automation-practice-form");
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
        $("#subjectsInput").setValue("Пример").pressEnter();
//      Выбор хобби
       //$("[for=hobbies-checkbox-1]").click(); не работает
        //$("[for='hobbies-checkbox-1']").click();
//Select picture
        //$("#uploadPicture").uploadFromClasspath("1 задание 2021-12-10.png");
// Current Address
        $("#currentAddress").setValue("Наметкина");

//Select State
        //$("#state").click();
        //$(".css-1wa3eu0-placeholder").click();



        //$("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        //$("#city").click();
        //$("#stateCity-wrapper").$(byText("")).click();
        //$("#submit").click();
// Select City




    }
}
