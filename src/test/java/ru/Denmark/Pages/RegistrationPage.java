package ru.Denmark.Pages;

import com.codeborne.selenide.SelenideElement;
import ru.Denmark.Pages.componnents.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            hobbies = $("[for='hobbies-checkbox-1']"),
            uploadPicture = $("#uploadPicture"),
            stateScroll = $("#state"),
            stateCityInput = $("#stateCity-wrapper"),
            CityInput = $("#city"),
            submitBtn = $("#submit"),
            tableResults = $(".table-responsive");

    public CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationPage openPage() {

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage typefirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typelastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeuserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage ClickLink() {
        $("[for='gender-radio-2']").click();
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage typeDateOfBirth() {
        dateOfBirthInput.click();
        return this;
    }

    public RegistrationPage typeSubjectsInput() {
        subjectsInput.setValue("History").pressEnter();
        return this;
    }

    public RegistrationPage typeHobbiesInput() {
        hobbies.click();
        return this;
    }

    public RegistrationPage typeuploadPicture(String file) {
        uploadPicture.uploadFromClasspath(file);
        return this;
    }

    public RegistrationPage typecurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage typeStateScroll() {
        stateScroll.scrollTo().click();
        return this;
    }

    public RegistrationPage typeStateCity() {
        stateCityInput.$(byText("Uttar Pradesh")).click();
        return this;
    }

    public RegistrationPage typeCity() {
        CityInput.click();
        return this;
    }

    public RegistrationPage typeStateCity2() {
        stateCityInput.$(byText("Lucknow")).click();
        return this;
    }

    public RegistrationPage typeBtn() {
        submitBtn.scrollTo().click();
        return this;
    }

    public RegistrationPage checkResultsValue(String value) {
        tableResults.shouldHave(text(value));
        return this;
    }
}



