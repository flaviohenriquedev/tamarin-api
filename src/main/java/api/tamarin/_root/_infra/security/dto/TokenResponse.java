package api.tamarin._root._infra.security.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record TokenResponse(
        String token,
        Date expiresToken,
        String refreshToken,
        Date expiresRefreshToken
) {
}
