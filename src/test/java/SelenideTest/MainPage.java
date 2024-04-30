package SelenideTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    //Главная страница сайта appleinsider.ru
    private final SelenideElement searchButton = $x("//form");

    public MainPage (String url){
        Selenide.open(url);
    }

    public void clickOnSearch() {
        searchButton.click();
    }

}
