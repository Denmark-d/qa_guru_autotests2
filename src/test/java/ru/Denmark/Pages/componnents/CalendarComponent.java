package ru.Denmark.Pages.componnents;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void SetDate (){
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
    }
}
