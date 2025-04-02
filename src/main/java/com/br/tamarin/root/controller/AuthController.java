package com.br.tamarin.root.controller;

import com.br.tamarin.root.auth.TokenService;
import com.br.tamarin.root.dto.LoginRequestDTO;
import com.br.tamarin.usuario.entity.Usuario;
import com.br.tamarin.usuario.repository.UsuarioRepository;
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
    public ResponseEntity<Usuario> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Usuario usuario = this.usuarioRepository.findByEmail(loginRequestDTO.email()).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado")
        );

        if (passwordEncoder.matches(loginRequestDTO.senha(), usuario.getSenha())) {
            String token = this.tokenService.gerarToken(usuario);
            usuario.setToken(token);
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.badRequest().build();
    }
}
