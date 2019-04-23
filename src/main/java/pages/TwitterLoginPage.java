package pages;

import base.BasePage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import model.User;

public class TwitterLoginPage extends BasePage {

    private LoginBlock loginBlock = new LoginBlock();

    @Step
    public static TwitterLoginPage open() {
        return Selenide.open("", TwitterLoginPage.class);
    }

    @Step
    public TwitterLandingPage loginAs(User user) {
        loginBlock.login(user);

        return new TwitterLandingPage();
    }
}
