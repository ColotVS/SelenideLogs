package Core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public abstract class BaseTest {

    public static void setUp() {
        WebDriverManager.chromedriver().setup();    //Скачиваем хром драйвер и устанавливаем его
        Configuration.browser = "chrome";           //Указываем браузер
        Configuration.webdriverLogsEnabled = true;  //Указываем на работу с WebDriverManager
        Configuration.browserSize = "1920x1080";    //Размер окна
        Configuration.headless = false;              //Видимость окна браузера при выполнении теста, для видимости указать false
    }

    @BeforeAll
    public static void init() {
        setUp();
    }

    @AfterAll
    public static void down() {
        Selenide.closeWebDriver();  //Закрываем страницу теста
    }
}
