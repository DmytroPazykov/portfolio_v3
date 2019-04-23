package service;

import org.apache.commons.lang3.RandomStringUtils;

import model.User;

public final class UserFactory {
    private UserFactory() {
    }

    public static User getDefaultUser() {
        return User.builder()
                .email("pazykov.epam@gmail.com")
                .password("testPassword123")
                .firstName("TestUser")
                .build();
    }

    public static User getRandomUser() {
        return User.builder()
                .userName(RandomStringUtils.randomAlphabetic(6))
                .firstName(RandomStringUtils.randomAlphabetic(6))
                .lastName(RandomStringUtils.randomAlphabetic(6))
                .password(RandomStringUtils.randomAlphabetic(10) + "@gmail.com")
                .password(RandomStringUtils.randomAlphanumeric(8))
                .build();
    }
}
