package pl.sdejnert.restApiDemo.core.rest;

import org.springframework.stereotype.Component;
import pl.sdejnert.restApiDemo.core.dto.GitUserResponseDto;
import pl.sdejnert.restApiDemo.core.dto.UserResponseDto;

import java.math.BigDecimal;

@Component
public class UserResponseDtoMapper {

    public UserResponseDto toDto(final GitUserResponseDto gitUserResponseDto, final BigDecimal calculations) {
        return UserResponseDto.builder()
                .id(gitUserResponseDto.getId())
                .login(gitUserResponseDto.getLogin())
                .name(gitUserResponseDto.getName())
                .type(gitUserResponseDto.getType())
                .avatarUrl(gitUserResponseDto.getAvatar_url())
                .createdAt(gitUserResponseDto.getCreated_at())
                .calculations(calculations)
                .build();
    }
}
