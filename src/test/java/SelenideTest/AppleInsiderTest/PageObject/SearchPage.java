package SelenideTest.AppleInsiderTest.PageObject;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    private final ElementsCollection articleTitle = $$x("//h2//a");

    /**
     * @return возвращает href из первой статьи
     */
    public String getHrefOnFirstArticle() {
        return articleTitle.first().getAttribute("href");
    }
}
