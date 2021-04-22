package net.unit8.drill.solid.choreography;

import net.unit8.drill.solid.*;
import net.unit8.drill.solid.adapter.impl.DeleteUserPortImpl;
import net.unit8.drill.solid.adapter.impl.LoadUserPortImpl;
import net.unit8.drill.solid.adapter.impl.PushNotificationPortImpl;
import net.unit8.drill.solid.adapter.impl.SendEmailPortImpl;
import net.unit8.drill.solid.domain.UserId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * コレオグラフィーのテスト。
 *
 * イベントリスナーをImportし忘れてもエラーにならず動くところが、
 * 便利でもあり、注意すべきところでもある。
 */
@SpringBootTest
@Import({DeleteUserCommandHandler.class,
        LoadUserPortImpl.class,
        DeleteUserPortImpl.class,
        SendEmailPortImpl.class,
        PushNotificationPortImpl.class,
        PushNotificationOnDeleteUserHandler.class,
        SendEmailOnDeleteUserHandler.class
})
class DeleteUserCommandHandlerTest {
    @Autowired
    private DeleteUserCommandHandler sut;

    @Test
    void test() {
        sut.handle(new DeleteUserCommand(
                new UserId("1")
        ));
    }
}