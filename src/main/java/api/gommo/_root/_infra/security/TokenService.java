package api.gommo._root._infra.security;

import api.gommo._root._infra.security.dto.TokenResponse;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.jwt.secretkey}")
    private String secret;

    @Value("${api.jwt.tokenexpiration}")
    private Integer tokenExpiration;

    @Value("${api.jwt.refreshtokenexpiration}")
    private Integer refreshTokenExpiration;

    public TokenResponse getToken(Usuario usuario) {
        return TokenResponse
                .builder()
                .token(generateToken(usuario, tokenExpiration))
                .expiresToken(Date.from(this.getExpiration(tokenExpiration)))
                .refreshToken(generateToken(usuario, refreshTokenExpiration))
                .expiresRefreshToken(Date.from(this.getExpiration(refreshTokenExpiration)))
                .build();
    }

    private String generateToken(Usuario usuario, Integer expiration) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("login-auth-api")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(this.getExpiration(expiration))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return ResponseEntity.ok(
                    JWT.require(algorithm)
                            .withIssuer("login-auth-api")
                            .build()
                            .verify(token)
                            .getSubject()
            );
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException(e.getMessage());
        }
    }

    private Instant getExpiration(Integer expiration) {
        return LocalDateTime
                .now()
                .plusHours(expiration)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
