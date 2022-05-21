package pl.sdejnert.restApiDemo.core.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdejnert.restApiDemo.core.database.entity.User;
import pl.sdejnert.restApiDemo.core.database.repositories.UserCallsRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCallsService {

    private final UserCallsRepository callsRepository;
    private final UserCallsMapper userCallsMapper;

    public void createOrUpdateCallForUser(final String login) {
        Optional<User> userCalls = callsRepository.findByLogin(login);
        userCalls.map(this::updateUserCalls).orElseGet(() -> createUserCalls(login));
    }

    private User createUserCalls(final String login) {
        return callsRepository.save(userCallsMapper.toEntity(login));
    }

    private User updateUserCalls(final User userCalls) {
        return callsRepository.save(userCallsMapper.toEntity(userCalls));
    }

}
