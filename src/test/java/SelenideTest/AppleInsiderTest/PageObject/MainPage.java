package SelenideTest.AppleInsiderTest.PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    /**
     * Главная страница сайта appleinsider.ru
     */

    private final SelenideElement inputBox = $x("//input[@name='s']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    /**
     * Выполняется поиск на сайте среди статей и нажимается клавиша Enter
     *
     * @param search поисковый запрос
     */
    public SearchPage search(String search) {
        inputBox.setValue(search);
        inputBox.sendKeys(Keys.ENTER);
        return new SearchPage();
    }
}
