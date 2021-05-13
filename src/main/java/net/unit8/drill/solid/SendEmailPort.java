package net.unit8.drill.solid;

import net.unit8.drill.solid.domain.UserName;

public interface SendEmailPort {
    void send(String email, UserName name);
}
