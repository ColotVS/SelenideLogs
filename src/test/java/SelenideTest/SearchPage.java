package SelenideTest;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    private final ElementsCollection articleTitle = $$x("//h2//a");

    /**
     * Возвращает href из первой статьи
     * @return
     */
    public String getHrefOnFirstArticle(){
        return articleTitle.first().getAttribute("href");
    }
}
