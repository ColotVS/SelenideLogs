package SelenideTest;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {

    public void setUp(){
        WebDriverManager.chromedriver().setup();    //Скачиваем хром драйвер и устанавливаем его
        Configuration.browser = "chrome";           //Указываем браузер
        Configuration.webdriverLogsEnabled = true;  //Указываем на работу с WebDriverManager
        Configuration.browserSize = "1920x1080";    //Размер окна
        Configuration.headless = true;              //Видимость окна браузера при выполнении теста


    }
}
