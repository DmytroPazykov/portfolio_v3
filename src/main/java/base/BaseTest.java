package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://twitter.com/?lang=en";
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = false;
    }

    protected <T> T at(Class<T> tClass){
        try {
            return tClass.newInstance();
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    @AfterEach
    void tearDown(){
        Selenide.close();
    }
}
