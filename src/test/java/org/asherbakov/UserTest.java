package org.asherbakov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User("Антон", "test@mail.ru");
    }

    @Test
    @DisplayName("When user created with login 'Антон' and email 'test@mail.ru' returns correct answer")
    void createUserWithParameters() {
        String resultLogin = user.getLogin();
        String resultEmail = user.getEmail();
        Assertions.assertEquals(resultLogin, "Антон");
        Assertions.assertEquals(resultEmail, "test@mail.ru");
    }
    @Test
    @DisplayName("When user created without parameters returns correct answer")
    void createUserWithoutParameters() {
        user = new User();
        String resultLogin = user.getLogin();
        String resultEmail = user.getEmail();
        Assertions.assertNull(resultLogin, "Login is null");
        Assertions.assertNull(resultEmail, "Email is null");
    }

    @Test
    @DisplayName("When user email does not contain '@' or '.' returns error ")
    void emailIsCorrect() {
        String email = user.getEmail();
        org.assertj.core.api.Assertions.assertThat(email).contains("@", ".");
    }

    @Test
    @DisplayName("When user login and email is equals returns error ")
    void loginAndEmailIsEquals() {
        String resultLogin = user.getLogin();
        String resultEmail = user.getEmail();
        Assertions.assertNotEquals(resultLogin, resultEmail, "Login and email is equals");
    }
}
