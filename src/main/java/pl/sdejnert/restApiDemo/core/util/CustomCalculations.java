package pl.sdejnert.restApiDemo.core.util;

import pl.sdejnert.restApiDemo.core.dto.GitUserResponseDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CustomCalculations {

    public static BigDecimal calculate(final GitUserResponseDto gitUserResponseDto) {
        return new BigDecimal(gitUserResponseDto.getFollowers()).compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : new BigDecimal(6).divide(new BigDecimal(gitUserResponseDto.getFollowers()), 6, RoundingMode.HALF_UP).multiply(new BigDecimal(2).add(new BigDecimal(gitUserResponseDto.getPublic_repos())));
    }
}
