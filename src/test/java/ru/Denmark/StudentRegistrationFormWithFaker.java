package ru.Denmark;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormWithFaker {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String currentAddress = faker.address().streetAddress();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);

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
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("history").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("custom/1 .png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();
        $("#submit").scrollTo().click();
        $(".table table-dark table-striped table-bordered table-hover").isDisplayed();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName +" "+lastName),text(userEmail));
        $(".table-responsive").shouldHave(text(userNumber),text("29 July,1988"),text("history"),
                                                    text("1 .png"),text(currentAddress),text("Uttar Pradesh Lucknow"));


    }
}
