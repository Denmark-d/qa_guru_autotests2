package ru.Denmark;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class AlfaBankTest {
    @Test
    void testAlfa(){
        Selenide.open("https://alfabank.ru/");
        $(Selectors.byText("Вклады")).click();
        $("#filter").shouldHave(Condition.text("Накопительные продукты"));
        $(".a3l8nq").click();
        //Check
        $("a2op2t").shouldHave(Condition.text("Альфа-Счёт"));
    }
}
