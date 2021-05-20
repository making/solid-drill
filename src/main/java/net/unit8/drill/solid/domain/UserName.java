package net.unit8.drill.solid.domain;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validated;
import am.ik.yavi.core.Validator;
import am.ik.yavi.fn.Either;
import lombok.Value;

import java.io.Serializable;

@Value
public class UserName implements Serializable {
    private final static Validator<UserName> validator = ValidatorBuilder.<UserName>of()
            .constraint(UserName::getValue, "name", c -> c
                    .notBlank()
                    .lessThanOrEqual(50))
            .build();

    String value;

    private UserName(String value) {
        this.value = value;
    }

    public static Validated<UserName> of(String value) {
        UserName userName = new UserName(value);
        return validator.prefixed("username").applicative().validate(userName);
    }

    @Override
    public String toString() {
        return value;
    }
}
