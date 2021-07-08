import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("89169163660");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1998");
        $(".react-datepicker__month-select").selectOptionContainingText("March");
        $x("//div[@class='react-datepicker__week']/*[text()=27]").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/road.jpg"));
        $("#currentAddress").setValue("Russia");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();
        //Asserts
        $(".table-responsive").shouldHave(
                text("Alex Pereponov"),
                text("NCR Noida"));
    }

}
