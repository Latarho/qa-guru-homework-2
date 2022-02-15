package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;


public class PracticeFormTests {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    String firstName = "Serg";
    String lastName = "Pomytkin";
    String email = "latarho@mail.ru";
    String mobileNumber = "8800555555";
    String subject = "Accounting";
    String pictureName = "test.jpg";
    String address = "Moscow, Surikova street";
    String headerFormTitle = "Thanks for submitting the form";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void fillAllFieldsPracticeFormTest()  {
        practiceFormPage.openPage();

        practiceFormPage.setFirstName(firstName);
        practiceFormPage.setLastName(lastName);
        practiceFormPage.setEmail(email);
        practiceFormPage.selectMaleGender();
        practiceFormPage.setMobileNumberInput(mobileNumber);
        practiceFormPage.setBirthDate("9", "October", "1991");
        practiceFormPage.selectSubjects(subject);
        practiceFormPage.selectMusicHobbies();
        practiceFormPage.uploadPicture(pictureName);
        practiceFormPage.setAddress(address);
        practiceFormPage.selectStateAndCityNCRDelhi();
        practiceFormPage.clickSubmitButton();

        practiceFormPage.checkHeader(headerFormTitle);
        practiceFormPage.checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", email)
                .checkForm("Gender", "Male")
                .checkForm("Mobile", mobileNumber)
                .checkForm("Date of Birth", "09 October,1991")
                .checkForm("Subjects", subject)
                .checkForm("Hobbies", "Music")
                .checkForm("Address", address)
                .checkForm("State and City", "NCR Delhi");

    }
}