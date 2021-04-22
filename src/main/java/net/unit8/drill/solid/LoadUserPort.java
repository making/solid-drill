package net.unit8.drill.solid;

import net.unit8.drill.solid.domain.User;
import net.unit8.drill.solid.domain.UserId;

public interface LoadUserPort {
    User load(UserId userId);
}
