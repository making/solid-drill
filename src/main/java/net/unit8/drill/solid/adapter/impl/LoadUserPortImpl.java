package net.unit8.drill.solid.adapter.impl;

import net.unit8.drill.solid.LoadUserPort;
import net.unit8.drill.solid.domain.EmailAddress;
import net.unit8.drill.solid.domain.User;
import net.unit8.drill.solid.domain.UserId;
import org.springframework.stereotype.Component;

@Component
public class LoadUserPortImpl implements LoadUserPort {
    @Override
    public User load(UserId userId) {
        return new User(userId, "default", new EmailAddress("default", "example.com"));
    }
}
