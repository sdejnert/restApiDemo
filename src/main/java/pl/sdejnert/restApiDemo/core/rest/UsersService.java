package pl.sdejnert.restApiDemo.core.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdejnert.restApiDemo.core.dto.GitUserResponseDto;
import pl.sdejnert.restApiDemo.core.dto.UserResponseDto;
import pl.sdejnert.restApiDemo.core.util.CustomCalculations;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UserCallsService userCallsService;
    private final UserResponseDtoMapper userResponseDtoMapper;

    public UserResponseDto saveCallAndReturnUserResponseDto(final GitUserResponseDto gitUserResponseDto) {
        userCallsService.createOrUpdateCallForUser(gitUserResponseDto.getLogin());
        return userResponseDtoMapper.toDto(gitUserResponseDto, CustomCalculations.calculate(gitUserResponseDto));
    }

}
