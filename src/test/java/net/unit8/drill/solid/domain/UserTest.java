package net.unit8.drill.solid.domain;

import am.ik.yavi.core.ConstraintViolationsException;
import am.ik.yavi.core.Validated;
import am.ik.yavi.fn.Validations;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @Test
    void valid() {
        Validated<User> validatedUser = Validations.combine(UserName.of("kawasima"), EmailAddress.of("kawasima1016", "gmail.com"))
                .apply((username, email) -> new User(new UserId("1111"), username, email));
        User user = validatedUser.orElseThrow(ConstraintViolationsException::new);
        assertThat(user.name().getValue()).isEqualTo("kawasima");
    }

    @Test
    void tooLongName() {
        Validated<User> validatedUser = Validations.combine(UserName.of("kawasimakawasimakawasimakawasimakawasimakawasimakawasima"), EmailAddress.of("kawasima1016", "gmail.com"))
                .apply((username, email) -> new User(new UserId("1111"), username, email));
        Assertions.assertThatThrownBy(() -> validatedUser.orElseThrow(ConstraintViolationsException::new)
        ).isExactlyInstanceOf(ConstraintViolationsException.class)
        .hasMessageContaining("username.name");
    }
}