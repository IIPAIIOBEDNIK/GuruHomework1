import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void PositiveTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Pereponov");
        $("#userEmail").setValue("pereponov_alexander@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9169163660");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1998");
        $(".react-datepicker__month-select").selectOptionContainingText("March");
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/road.jpg"));
        $("#currentAddress").setValue("Russia");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").scrollTo().click();
        //Assertions
        $(".table-responsive").shouldHave(
                text("Alex Pereponov"),
                text("pereponov_alexander@mail.ru"),
                text("Male"),
                text("9169163660"),
                text("27 March,1998"),
                text("Maths"),
                text("Music"),
                text("road.jpg"),
                text("Russia"),
                text("NCR Noida"));
    }

}
