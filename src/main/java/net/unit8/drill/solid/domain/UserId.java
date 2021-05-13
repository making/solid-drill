package net.unit8.drill.solid.domain;

import lombok.Value;

@Value
public class UserId {
    String value;

    @Override
    public String toString() {
        return value;
    }
}
