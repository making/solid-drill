package net.unit8.drill.solid.domain;

import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.fn.Either;
import net.unit8.drill.solid.constraint.EitherMerger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.util.function.Tuple2;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @Test
    void valid() {
        Either<ConstraintViolations, Tuple2<UserName, EmailAddress>> either = EitherMerger.merge(
                UserName.of("kawasima"),
                EmailAddress.of("kawasima1016", "gmail.com"));
        Tuple2<UserName, EmailAddress> t = either.rightOrElseThrow(violations -> new IllegalArgumentException(violations.toString()));
        User user = new User(new UserId("1111"),
                t.getT1(),
                t.getT2());
        assertThat(user.name().getValue()).isEqualTo("kawasima");
    }

    @Test
    void tooLongName() {
        Either<ConstraintViolations, Tuple2<UserName, EmailAddress>> either = EitherMerger.merge(
                UserName.of("kawasimakawasimakawasimakawasimakawasimakawasimakawasima"),
                EmailAddress.of("kawasima1016", "gmail.com"));
        Assertions.assertThatThrownBy(() -> either
                .rightOrElseThrow(violations -> new IllegalArgumentException(violations.toString()))
        ).isExactlyInstanceOf(IllegalArgumentException.class);

    }
}