package base;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import logger.TestLifecycleLogger;
import logger.TimingExtension;
import lombok.NonNull;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(TimingExtension.class)
public class BaseTest implements TestLifecycleLogger {

    @BeforeEach
    void setup() throws MalformedURLException {
        String runType = System.getProperty("runType", "local");
        System.out.println("runType is - " + runType);

        Configuration.baseUrl = "https://twitter.com/?lang=en";
        Configuration.startMaximized = false;

        switch (runType) {
            case ("local"):
                Configuration.browserSize = "1920x1080";
                break;
            case ("chrome_72"):
                remoteBrowserSetup(Browsers.CHROME, "72.0");
                break;
            case ("chrome_71"):
                remoteBrowserSetup(Browsers.CHROME, "71.0");
                break;
            case ("chrome_70"):
                remoteBrowserSetup(Browsers.CHROME, "70.0");
                break;
            case ("chrome_69"):
                remoteBrowserSetup(Browsers.CHROME, "69.0");
                break;
            case ("firefox_66"):
                remoteBrowserSetup(Browsers.FIREFOX, "66.0");
                break;
            case ("android_8.1"):
                remoteBrowserSetup("android", "8.0", "QVGA", "240x320");
            default:
                throw new NoSuchElementException("Please specify browser for a test run");
        }

    }

    private void remoteBrowserSetup(@NonNull String browserName, @NonNull String version) throws MalformedURLException {
        Configuration.browser = browserName;
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName(browserName);
        browser.setVersion(version);
        browser.setCapability("enableVNC", true);
        browser.setCapability("enableVideo", true);
        RemoteWebDriver driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), browser);
        setWebDriver(driver);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    private void remoteBrowserSetup(@NonNull String browserName, @NonNull String version, @NonNull String skin, @NonNull String resolution) throws MalformedURLException {
        Configuration.browser = browserName;
        DesiredCapabilities device = new DesiredCapabilities();
        device.setCapability("browserName",browserName);
        device.setCapability("version",version);
        device.setCapability("enableVNC", true);
        device.setCapability("skin", skin);
        device.setCapability("resolution", resolution);
        device.setCapability("appPackage", "com.android");
        device.setCapability("appActivity", "com.android.chrome_73");
        RemoteWebDriver driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), device);
        setWebDriver(driver);
    }

    protected <T> T at(Class<T> atClass) {
        try {
            return atClass.newInstance();
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    @AfterEach
    void tearDown() {
        Selenide.close();
    }
}
