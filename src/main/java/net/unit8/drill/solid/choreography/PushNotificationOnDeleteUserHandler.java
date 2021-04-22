package net.unit8.drill.solid.choreography;

import net.unit8.drill.solid.PushNotificationPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class PushNotificationOnDeleteUserHandler {
    private final PushNotificationPort pushNotificationPort;

    public PushNotificationOnDeleteUserHandler(PushNotificationPort pushNotificationPort) {
        this.pushNotificationPort = pushNotificationPort;
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    void handle(UserDeletedEvent event) {
        pushNotificationPort.push();
    }
}
