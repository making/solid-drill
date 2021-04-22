package net.unit8.drill.solid.adapter.impl;

import net.unit8.drill.solid.DeleteUserPort;
import net.unit8.drill.solid.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserPortImpl implements DeleteUserPort {
    private static final Logger LOG = LoggerFactory.getLogger(DeleteUserPortImpl.class);
    @Override
    public void delete(User user) {
        LOG.info("Delete user: {}", user.name());
    }
}
