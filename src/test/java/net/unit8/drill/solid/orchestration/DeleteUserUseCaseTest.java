package net.unit8.drill.solid.orchestration;

import net.unit8.drill.solid.DeleteUserCommand;
import net.unit8.drill.solid.adapter.impl.DeleteUserPortImpl;
import net.unit8.drill.solid.adapter.impl.LoadUserPortImpl;
import net.unit8.drill.solid.adapter.impl.PushNotificationPortImpl;
import net.unit8.drill.solid.adapter.impl.SendEmailPortImpl;
import net.unit8.drill.solid.domain.UserId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({DeleteUserUseCase.class,
        LoadUserPortImpl.class,
        DeleteUserPortImpl.class,
        SendEmailPortImpl.class,
        PushNotificationPortImpl.class,
})
class DeleteUserUseCaseTest {
    @Autowired
    DeleteUserUseCase sut;

    @Test
    void test() {
        sut.handle(new DeleteUserCommand(
                new UserId("1")
        ));
    }
}