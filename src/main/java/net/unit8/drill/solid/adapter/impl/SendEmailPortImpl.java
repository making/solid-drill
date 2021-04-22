package net.unit8.drill.solid.adapter.impl;

import net.unit8.drill.solid.SendEmailPort;
import org.springframework.stereotype.Component;

@Component
public class SendEmailPortImpl implements SendEmailPort {
    @Override
    public void send(String email, String name) {

    }
}
