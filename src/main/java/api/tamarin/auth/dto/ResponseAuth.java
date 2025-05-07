package api.tamarin.auth.dto;

import java.util.UUID;

public record ResponseAuth(
        UUID id,
        String name,
        String email,
        String accessToken
) {
}
