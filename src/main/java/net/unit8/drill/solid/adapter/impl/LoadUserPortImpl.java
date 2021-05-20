package net.unit8.drill.solid.adapter.impl;

import am.ik.yavi.core.ConstraintViolationsException;
import am.ik.yavi.fn.Validations;
import net.unit8.drill.solid.LoadUserPort;
import net.unit8.drill.solid.domain.EmailAddress;
import net.unit8.drill.solid.domain.User;
import net.unit8.drill.solid.domain.UserId;
import net.unit8.drill.solid.domain.UserName;

import org.springframework.stereotype.Component;

@Component
public class LoadUserPortImpl implements LoadUserPort {
    @Override
    public User load(UserId userId) {
        return Validations.combine(UserName.of("default"), EmailAddress.of("default", "example.com"))
                .apply((username, email) -> new User(userId, username, email))
                .orElseThrow(ConstraintViolationsException::new);
    }
}
