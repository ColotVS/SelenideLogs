import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class LogsTest {
    @BeforeEach
    public void setUp(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();

        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);

        desiredCapabilities.setCapability("goog:loggingPrefs",loggingPreferences);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);

        Configuration.browserCapabilities = desiredCapabilities;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;

    }
}
