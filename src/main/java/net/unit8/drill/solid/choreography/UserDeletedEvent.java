package net.unit8.drill.solid.choreography;

import net.unit8.drill.solid.domain.UserName;

public record UserDeletedEvent(UserName name,
                               String email) {
}
