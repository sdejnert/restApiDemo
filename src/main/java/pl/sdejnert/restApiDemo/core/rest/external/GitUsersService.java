package pl.sdejnert.restApiDemo.core.rest.external;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sdejnert.restApiDemo.core.dto.GitUserResponseDto;
import pl.sdejnert.restApiDemo.core.util.RequestUrlQueryCreator;

@Service
@RequiredArgsConstructor
public class GitUsersService {

    private final RequestUrlQueryCreator requestUrlQueryCreator;
    private final RestTemplate restTemplate;

    private static final String GET_GIT_USER_DATA = "https://api.github.com/users/";

    public Either<String, GitUserResponseDto> findGitUserByLogin(final String login) {
        final String requestUrl = requestUrlQueryCreator.create(GET_GIT_USER_DATA, login);
        try {
            ResponseEntity<GitUserResponseDto> gitUserResponseDtoResponseEntity = restTemplate.getForEntity(requestUrl, GitUserResponseDto.class);
            if (gitUserResponseDtoResponseEntity.getStatusCode() == HttpStatus.OK) {
                return Either.right(gitUserResponseDtoResponseEntity.getBody());
            }
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
        return Either.left(String.format("User %s not found", login));
    }
}
