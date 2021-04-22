package net.unit8.drill.solid.choreography;

import net.unit8.drill.solid.SendEmailPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class SendEmailOnDeleteUserHandler {
    private static final Logger LOG = LoggerFactory.getLogger(SendEmailOnDeleteUserHandler.class);
    private final SendEmailPort sendEmailPort;

    public SendEmailOnDeleteUserHandler(SendEmailPort sendEmailPort) {
        this.sendEmailPort = sendEmailPort;
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handle(UserDeletedEvent event) {
        sendEmailPort.send(event.email(), event.name());
        LOG.info("Send email to user {}", event.name());
    }
}
