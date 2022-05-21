package pl.sdejnert.restApiDemo.core.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sdejnert.restApiDemo.core.dto.ResponseMessage;
import pl.sdejnert.restApiDemo.core.rest.external.GitUsersService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UsersService usersService;
    private final GitUsersService gitUsersService;

    @GetMapping("/user/{login}")
    public ResponseEntity<?> findByLogin(@PathVariable final String login) {
        log.info(String.format("Zapytanie dla loginu: %s", login));
        return gitUsersService.findGitUserByLogin(login).fold(
                error -> ResponseEntity.badRequest().body(new ResponseMessage(error)),
                gitUserResponseDto -> ResponseEntity.ok(usersService.saveCallAndReturnUserResponseDto(gitUserResponseDto))
        );
    }
}
