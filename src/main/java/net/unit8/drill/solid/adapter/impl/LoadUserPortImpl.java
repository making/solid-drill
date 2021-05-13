package net.unit8.drill.solid.adapter.impl;

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
        return new User(userId,
                UserName.of("default").rightOrElseThrow(violations -> new RuntimeException()),
                EmailAddress.of("default", "example.com").rightOrElseThrow(violations -> new RuntimeException()));
    }
}
