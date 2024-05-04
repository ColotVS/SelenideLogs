package SelenideTest.HeadHunterTest.PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HeadHunterResumePage {
    /*
      Страница резюме с сайта Head Hunter
     */
    private final SelenideElement gender = $x("//span[@data-qa='resume-personal-gender']");

    /**
     * Конструктор класса HeadHunterResumePage
     *
     * @param url передаем ссылку которую необходимо открыть
     */
    public HeadHunterResumePage(String url) {
        Selenide.open(url);
    }

    public String getGender() {
        String genderValue = gender.getText();
        if (genderValue.equals("Мужчина")) {
            return "М";
        } else return "Ж";
    }

    public String getGenderTernary() {
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
    }
}
