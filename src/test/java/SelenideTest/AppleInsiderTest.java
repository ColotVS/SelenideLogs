package SelenideTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppleInsiderTest extends BaseTest {
    //Задача:
    //1. Открыть сайт https://appleinsider.ru/
    //2. Нажать на кнопку поиска сверху справа.
    //3. Ввести текст "Чем iPhone 13 отличается от iPhone 12" и нажать Enter.
    //4. В найденных статьях найти href атрибут первой найденной статьи
    //5. Убедиться, что href ссылка содержит слово iphone-13

    private static final String BASE_URL = "https://appleinsider.ru/";
    private static final String SEARCH_STRING = "Чем iPhone 13 отличается от iPhone 12";
    private static final String COMPARATIVE_STRING = "iphone-13";

    @Test
    public void checkHrefTest() {
        Assertions.assertTrue(new MainPage(BASE_URL).search(SEARCH_STRING).getHrefOnFirstArticle().contains(COMPARATIVE_STRING));
    }
}
