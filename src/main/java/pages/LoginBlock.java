package pages;

import base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.User;

import static com.codeborne.selenide.Selenide.$;

public class LoginBlock extends BasePage {

    private SelenideElement userName = $(".LoginForm-username .email-input");
    private SelenideElement password = $(".LoginForm-password [type='password']");
    private SelenideElement loginBtn = $(".LoginForm  input[value='Log in']");
    private SelenideElement loginError = $(".alert-messages .message-text");

    @Step
    public void login(User user) {
        userName.setValue(user.getEmail());
        password.setValue(user.getPassword());

        loginBtn.click();
    }

    @Step
    public LoginBlock loginErrorDisplayed(String errorMessage) {
        loginError
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText(errorMessage));

        return this;
    }
}
