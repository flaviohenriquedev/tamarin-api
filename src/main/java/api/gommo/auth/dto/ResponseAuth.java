package api.gommo.auth.dto;

import java.util.Date;
import java.util.UUID;

public record ResponseAuth(
        UUID id,
        String name,
        String email,
        String accessToken,
        Date expiresToken,
        String refreshToken,
        Date expiresRefreshtoken
) {
}
