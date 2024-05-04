package SelenideTest.HeadHunterTest.PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class HeadHunterResumePage {
    /*
      Страница резюме с сайта Head Hunter
     */
    private final SelenideElement gender = $x("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement city = $x("//span[@data-qa='resume-personal-address']");
    private final SelenideElement liveData = $x("//span[@data-qa='resume-personal-address']/ancestor::p");  //Элемент на 1 выше предыдущего
    private final SelenideElement workPermit = $x("//div[@class='resume-block-container']/p[text()='Разрешение на работу']");
    public static String GENDER = "Пол";
    public static String AGE = "Возраст";
    public static String CITY = "Город";
    public static String READY_TO_RELOCATE = "Готовность к переезду";
    public static String READY_TO_BUSINESS_TRIPS = "Готовность к командировкам";
    public static String WORK_PERMIT = "Разрешение на работу";


    /**
     * Конструктор класса HeadHunterResumePage
     *
     * @param url передаем ссылку которую необходимо открыть
     */
    public HeadHunterResumePage(String url) {
        Selenide.open(url);
    }

    /**
     * Создание актуальной HashMap с парами ключ-значение
     *
     * @return возвращает актуальную HashMap с парами ключ-значение
     */
    public Map<String, Object> getAttributes() {
        return new HashMap<>() {
            {
                put(GENDER, getGender());
                put(AGE, getAge());
                put(CITY, getCity());
                put(READY_TO_RELOCATE, readyToRelocate());
                put(READY_TO_BUSINESS_TRIPS, readyToBusinessTrips());
                put(WORK_PERMIT, haveWorkPermitRussia());
            }
        };
    }

    /**
     * Вернуть пол, 1 вариант if-else
     *
     * @return Если веб-элемент возвращает Мужчина, то возвращаем М иначе Ж
     */
    public String getGender() {
        String genderValue = gender.getText();
        if (genderValue.equals("Мужчина")) {
            return "М";
        } else return "Ж";
    }

    /**
     * Вернуть пол, 2 вариант через тернарный оператор
     *
     * @return Если веб-элемент возвращает Мужчина, то возвращаем М иначе Ж
     */
    public String getGenderTernary() {
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
    }

    /**
     * Вернуть возраст
     *
     * @return Берем текст из веб-элемента, при помощи регулярного выражения удаляем из него все символы,
     * за исключением цифр и преобразуем полученное значение к типу int.
     */
    public int getAge() {
        return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
    }

    /**
     * Вернуть город
     *
     * @return Берем текст из веб-элемента
     */
    public String getCity() {
        return city.getText();
    }

    /**
     * Вернуть параметр готов к переезду
     *
     * @return получаем массив элементов с использованием метода split,
     * разделяющего текст на основание переданного выражения
     * далее берём элемент под индексом 1 и сравниваем его с текстовым значением
     */
    public boolean readyToRelocate() {
        return !liveData.getText().split(", ")[1].equals("не готов к переезду");
    }

    /**
     * Вернуть параметр готов к командировкам
     *
     * @return получаем массив элементов с использованием метода split,
     * разделяющего текст на основание переданного выражения
     * далее берём элемент под индексом 2 и сравниваем его с текстовым значением
     */
    public boolean readyToBusinessTrips() {
        return !liveData.getText().split(", ")[2].equals("не готов к командировкам");
    }

    /**
     * Вернуть параметр разрешение на работу
     *
     * @return получаем массив элементов с использованием метода split,
     * разделяющего текст на основание переданного выражения
     * далее берём элемент под индексом 1 и сравниваем его с текстовым значением
     */
    public boolean haveWorkPermitRussia() {
        return workPermit.getText().split(", ")[1].equals("Россия");
    }
}
