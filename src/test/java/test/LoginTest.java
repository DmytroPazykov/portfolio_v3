package test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import model.User;
import pages.LoginBlock;
import pages.TwitterLoginPage;
import service.UserFactory;

public class LoginTest extends BaseTest {

    @Test
    @Tag("ui")
    void userCanNotLoginWithIncorrectData() {
        User user = UserFactory.getRandomUser();

        TwitterLoginPage
                .open()
                .loginAs(user);

        at(LoginBlock.class)
                .loginErrorDisplayed("The username and password you entered did not match our records. Please double-check and try again.");
    }

    @Test
    @Tag("ui")
    void userCanLogin() {
        User user = UserFactory.getDefaultUser();

        TwitterLoginPage
                .open()
                .loginAs(user)
                .shouldBeLoggedAs(user);
    }

    @Test
    @Tag("ui")
    void userCanNotLoginWithIncorrectDataFailCase() {
        User user = UserFactory.getRandomUser();

        TwitterLoginPage
                .open()
                .loginAs(user);

        at(LoginBlock.class)
                .loginErrorDisplayed("fail");
    }
}
