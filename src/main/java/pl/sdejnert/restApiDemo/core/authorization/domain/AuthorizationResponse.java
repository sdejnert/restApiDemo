package pl.sdejnert.restApiDemo.core.authorization.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizationResponse {

    private String token;

}