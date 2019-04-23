package pages;

import base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.User;

import static com.codeborne.selenide.Selenide.$;

public class TwitterLandingPage extends BasePage {

    private SelenideElement loggedUserLink = $(".DashboardProfileCard-name");

    @Step
    public TwitterLandingPage shouldBeLoggedAs(User user) {
        loggedUserLink
                .waitUntil(Condition.visible, 10000)
                .shouldHave(Condition.exactText(user.getFirstName()));
        return this;
    }
}
