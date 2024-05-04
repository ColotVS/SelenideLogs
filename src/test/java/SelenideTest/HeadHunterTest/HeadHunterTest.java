package SelenideTest.HeadHunterTest;

import Core.BaseTest;
import SelenideTest.HeadHunterTest.PageObject.HeadHunterResumePage;
import org.junit.jupiter.api.Test;

public class HeadHunterTest extends BaseTest {
    /**
     * 1) Отрыть резюме, которое доступно по ссылке
     * https://barnaul.hh.ru/resume/c9b1fc850005ea401f0039ed1f6b50555a5769?query=QA+engineer&searchRid=1714802890239c1c903512a7e27ddcf0&hhtmFrom=resume_search_result

     * 2) Получить информацию о профиле используя HashMap или Class, в котором должны быть следующие атрибуты:
     * String sex, int age, String city, boolean readyToRelocate, boolean readyToBusinessTrips, boolean workPermitRussia;

     *  3) Убедиться в соответствии фактического и ожидаемого результата
     *  Ожидаемый результат sex = "M", age = 31, city = "Барнаул",
     *  readyToBusinessTrips = false, readyToRelocate = false, workPermitRussia = true.
     */
    private static final String BASE_URL = "https://barnaul.hh.ru/resume/c9b1fc850005ea401f0039ed1f6b50555a5769?query=QA+engineer&searchRid=1714802890239c1c903512a7e27ddcf0&hhtmFrom=resume_search_result";

    @Test
    public void checkAttributesHashMap(){
        HeadHunterResumePage headHunterResumePage = new HeadHunterResumePage(BASE_URL);
    }
}
