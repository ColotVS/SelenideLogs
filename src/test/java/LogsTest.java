import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.$x;

public class LogsTest {
    private final Supplier<ConditionFactory> WAITER = () -> Awaitility.given()
            .ignoreExceptions()
            .pollInterval(3, TimeUnit.SECONDS)
            .await()
            .dontCatchUncaughtExceptions()
            .atMost(10, TimeUnit.SECONDS);

    private boolean waitLogs(String expectedMessage) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        AtomicBoolean isLogContains = new AtomicBoolean(false);

        WAITER.get().until(() -> {
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            printLogs(logEntries);
            isLogContains.set(logEntries.getAll().stream().anyMatch(x -> x.getMessage().contains(expectedMessage)));
            return isLogContains.get();
        });
        return isLogContains.get();
    }

    private void printLogs (LogEntries logEntries){
        for(LogEntry entry:logEntries){
            System.out.println(entry);
        }
    }

    @Test
    public void checkLogsWithDelayTest(){
        Selenide.open("http://85.192.34.140/logdelay/");
        boolean isLogExist = waitLogs("ThreadQA secret message after 5 sec");
        Assertions.assertTrue(isLogExist,"Лог не пришёл");
    }

    @Test
    public void logsErrorTest(){
        Selenide.open("http://85.192.34.140:8081/");
        $x("//h5[text()='Elements']").click();
        $x("//li[@id='item-6']/span[contains(text(), 'Broken')]").click();
        $x("//p[text()='Broken image']").should(Condition.visible);

        String errorMessage = "http://85.192.34.140:8081/images/ThreadQa.jpg - Failed to load resource: " +
                "net::ERR_CONNECTION_REFUSED";

        boolean isContainsLogs = waitLogs(errorMessage);
        Assertions.assertTrue(isContainsLogs,"Сообщение в логах " + errorMessage + " не найдено");
    }
    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();

        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);

        desiredCapabilities.setCapability("goog:loggingPrefs", loggingPreferences);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        Configuration.browserCapabilities = desiredCapabilities;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;

    }
}
