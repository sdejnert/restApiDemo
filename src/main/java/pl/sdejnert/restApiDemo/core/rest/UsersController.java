package pl.sdejnert.restApiDemo.core.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sdejnert.restApiDemo.core.dto.ResponseMessage;
import pl.sdejnert.restApiDemo.core.rest.external.GitUsersService;
import pl.sdejnert.restApiDemo.core.rest.validation.Validator;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UsersService usersService;
    private final GitUsersService gitUsersService;
    private final Validator validator;

    @GetMapping("/user/{login}")
    public ResponseEntity<?> findByLogin(@PathVariable final String login) {
        log.info(String.format("Zapytanie dla loginu: %s", login));
        List<String> errors = validator.validateLogin(login);
        if (errors.isEmpty())
            return gitUsersService.findGitUserByLogin(login).fold(
                    error -> ResponseEntity.badRequest().body(new ResponseMessage(error)),
                    gitUserResponseDto -> ResponseEntity.ok(usersService.saveCallAndReturnUserResponseDto(gitUserResponseDto))
            );
        return ResponseEntity.badRequest().body(new ResponseMessage(errors.toString()));
    }
}
