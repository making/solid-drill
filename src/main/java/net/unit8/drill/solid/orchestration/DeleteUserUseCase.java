package net.unit8.drill.solid.orchestration;

import net.unit8.drill.solid.*;
import net.unit8.drill.solid.domain.User;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserUseCase {
    private final LoadUserPort loadUserPort;
    private final DeleteUserPort deleteUserPort;
    private final SendEmailPort sendEmailPort;
    private final PushNotificationPort pushNotificationPort;

    public DeleteUserUseCase(LoadUserPort loadUserPort, DeleteUserPort deleteUserPort, SendEmailPort sendEmailPort, PushNotificationPort pushNotificationPort) {
        this.loadUserPort = loadUserPort;
        this.deleteUserPort = deleteUserPort;
        this.sendEmailPort = sendEmailPort;
        this.pushNotificationPort = pushNotificationPort;
    }

    public void handle(DeleteUserCommand command) {
        User user = loadUserPort.load(command.targetUserId());
        deleteUserPort.delete(user);
        sendEmailPort.send(user.email().toString(), user.name());
        pushNotificationPort.push();
    }
}
