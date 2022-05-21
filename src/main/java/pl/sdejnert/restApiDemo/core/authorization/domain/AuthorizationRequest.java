package pl.sdejnert.restApiDemo.core.authorization.domain;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AuthorizationRequest {

    private String username;
    private String password;

}