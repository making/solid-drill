package net.unit8.drill.solid;

import net.unit8.drill.solid.domain.UserId;

public record DeleteUserCommand(UserId targetUserId) {
}
