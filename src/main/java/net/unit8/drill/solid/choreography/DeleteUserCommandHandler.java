package net.unit8.drill.solid.choreography;

import net.unit8.drill.solid.DeleteUserCommand;
import net.unit8.drill.solid.DeleteUserPort;
import net.unit8.drill.solid.LoadUserPort;
import net.unit8.drill.solid.domain.User;
import net.unit8.drill.solid.domain.UserName;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteUserCommandHandler {
    private final ApplicationEventPublisher publisher;
    private final LoadUserPort loadUserPort;
    private final DeleteUserPort deleteUserPort;

    public DeleteUserCommandHandler(ApplicationEventPublisher publisher,
                                    LoadUserPort loadUserPort, DeleteUserPort deleteUserPort) {
        this.publisher = publisher;
        this.loadUserPort = loadUserPort;
        this.deleteUserPort = deleteUserPort;
    }

    @Transactional
    public void handle(DeleteUserCommand command) {
        User user = loadUserPort.load(command.targetUserId());
        deleteUserPort.delete(user);
        publisher.publishEvent(new UserDeletedEvent(
                user.name(),
                user.email().toString()
        ));
    }
}
