package net.unit8.drill.solid.adapter.impl;

import net.unit8.drill.solid.SendEmailPort;
import net.unit8.drill.solid.domain.UserName;
import org.springframework.stereotype.Component;

@Component
public class SendEmailPortImpl implements SendEmailPort {
    @Override
    public void send(String email, UserName name) {

    }
}
