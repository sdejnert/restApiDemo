package pl.sdejnert.restApiDemo.core.rest;

import org.springframework.stereotype.Component;
import pl.sdejnert.restApiDemo.core.database.entity.User;

@Component
public class UserCallsMapper {

    public User toEntity(final String login) {
        return User.builder()
                .id(0)
                .login(login)
                .request_count(1)
                .build();
    }

    public User toEntity(final User userCalls) {
        return userCalls.toBuilder()
                .request_count(userCalls.getRequest_count() + 1)
                .build();
    }

}
