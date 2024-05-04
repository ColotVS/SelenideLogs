package SelenideTest.HeadHunterTest.PageObject;

import com.codeborne.selenide.Selenide;

public class HeadHunterResumePage {
    /*
      Страница резюме с сайта Head Hunter
     */

    /**
     * Конструктор класса HeadHunterResumePage
     * @param url передаем ссылку которую необходимо открыть
     */
    public HeadHunterResumePage(String url) {
        Selenide.open(url);
    }
}
