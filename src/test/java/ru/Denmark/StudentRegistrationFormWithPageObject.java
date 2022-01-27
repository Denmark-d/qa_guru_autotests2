package ru.Denmark;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.Denmark.Pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormWithPageObject {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1920x1080";
    }
    @Test
    void firstTest(){
        System.out.println("First Test");
         registrationPage.openPage();
         registrationPage.typefirstName("Danny");
         registrationPage.typelastName("Dan");
        registrationPage.typeuserEmail("Danny@mail.ru");
        registrationPage.ClickLink();
        registrationPage.typeUserNumber("89371703123");
        registrationPage.typeDateOfBirth();
        registrationPage.calendarComponent.SetDate();
        registrationPage.typeSubjectsInput();
        registrationPage.typeHobbiesInput();
        registrationPage.typeuploadPicture("custom/1 .png");
        registrationPage.typecurrentAddress("Наметкина");
        registrationPage.typeStateScroll();
        registrationPage.typeStateCity();
        registrationPage.typeCity();
        registrationPage.typeStateCity2();
        registrationPage.typeBtn();
        //$(".table table-dark table-striped table-bordered table-hover").isDisplayed();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //$(".table-responsive").shouldHave(text("Danny Dan"),text("Danny@mail.ru"));
        //$(".table-responsive").shouldHave(text("8937170312"),text("29 July,1988"),text("history"),
                                                    //text("1 .png"),text("Наметкина"),text("Uttar Pradesh Lucknow"));
         registrationPage.checkResultsValue("Danny Dan")
                         .checkResultsValue("Danny@mail.ru")
                         .checkResultsValue("8937170312")
                         .checkResultsValue("29 July,1988")
                         .checkResultsValue("history")
                         .checkResultsValue("1 .png")
                         .checkResultsValue("Наметкина")
                         .checkResultsValue("Uttar Pradesh Lucknow");

    }
}
