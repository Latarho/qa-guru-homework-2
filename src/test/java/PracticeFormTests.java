import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void fillAllFieldsPracticeFormTest()  {
        open("/automation-practice-form");
        $x("//*[@id ='firstName']").setValue("Serg");
        $x("//*[@id ='lastName']").setValue("Pomytkin");
        $x("//input[@placeholder='name@example.com']").setValue("latarho@mail.ru");
        $x("//*[text() = 'Male']").click();
        $x("//input[@placeholder='Mobile Number']").setValue("8800555555");
        $x("//*[@id ='dateOfBirthInput']").click();
        $x("//*[@class='react-datepicker__month-select']").selectOption("October");
        $x("//*[@class='react-datepicker__year-select']").selectOption("1991");
        $x("//*[@class='react-datepicker__day react-datepicker__day--009']").click();
        $x("//*[@id ='subjectsInput']").setValue("Accounting").pressEnter();
        $x("//*[text() = 'Music']").click();
        $x("//*[@id ='uploadPicture']").uploadFromClasspath("test.jpg");
        $x("//*[@id ='currentAddress']").setValue("Moscow");
        $x("//*[@id='state']").click();
        $x("//*[text() = 'NCR']").click();
        $x("//*[@id ='city']").click();
        $x("//*[text() ='Delhi']").click();
        $x("//*[text() = 'Submit']").click();

        $x("//*[@class ='modal-header']").shouldHave(text("Thanks for submitting the form"));

        $x("//*[@class='table-responsive']").shouldHave(text("Student Name Serg Pomytkin"),
                text("Student Email latarho@mail.ru"),
                text("Gender Male"), text("Mobile 8800555555"), text("Date of Birth 09 October,1991"),
                text("Subjects Accounting"), text("Hobbies Music"), text("Picture"),
                text("Address Moscow"), text("State and City NCR Delhi"));
    }
}