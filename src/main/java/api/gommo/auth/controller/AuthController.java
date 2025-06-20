package api.gommo.auth.controller;

import api.gommo._root._infra.security.TokenService;
import api.gommo._root._infra.security.dto.TokenResponse;
import api.gommo.auth.dto.LoginRequestDTO;
import api.gommo.auth.dto.RegisterAuthDTO;
import api.gommo.auth.dto.ResponseAuth;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<ResponseAuth> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginRequestDTO.email()).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        if (passwordEncoder.matches(loginRequestDTO.senha(), usuario.getSenha())) {
            TokenResponse tokenResponse = tokenService.getToken(usuario);
            return ResponseEntity.ok(new ResponseAuth(
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    tokenResponse.token(),
                    tokenResponse.expiresToken(),
                    tokenResponse.refreshToken(),
                    tokenResponse.expiresRefreshToken()
            ));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/get-refresh-token")
    public ResponseEntity<TokenResponse> getRefreshToken(@RequestBody String refreshToken) {
        var login = tokenService.validateToken(refreshToken).getBody();
        Usuario usuario = usuarioRepository.findByEmail(login).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return ResponseEntity.ok(tokenService.getToken(usuario));
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody RegisterAuthDTO registerAuthDTO) {
        if (!usuarioRepository.existsByEmail(registerAuthDTO.email())) {
            Usuario novoUsuario = new Usuario();
            novoUsuario.setSenha(passwordEncoder.encode("12345"));
            novoUsuario.setNome(registerAuthDTO.nome());
            novoUsuario.setEmail(registerAuthDTO.email());
            novoUsuario.setCpf(registerAuthDTO.cpf());
            this.usuarioRepository.save(novoUsuario);

            TokenResponse tokenResponse = tokenService.getToken(novoUsuario);
            novoUsuario.setToken(tokenResponse.token());
            return ResponseEntity.ok(novoUsuario);
        }

        return ResponseEntity.badRequest().build();
    }
}
