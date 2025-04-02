package com.br.tamarin.root.controller;

import com.br.tamarin.root.auth.TokenService;
import com.br.tamarin.root.dto.LoginRequestDTO;
import com.br.tamarin.root.dto.RegisterDTO;
import com.br.tamarin.root.dto.ResponseLoginDTO;
import com.br.tamarin.usuario.entity.Usuario;
import com.br.tamarin.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Usuario usuario = this.usuarioRepository.findByEmail(loginRequestDTO.email()).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado")
        );

        if(passwordEncoder.matches(loginRequestDTO.password(), usuario.getSenha())) {
            String token = this.tokenService.gerarToken(usuario);
            return ResponseEntity.ok(new ResponseLoginDTO(token, usuario.getNome()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO) {
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(registerDTO.email());

        if(usuario.isEmpty()) {
            Usuario novoUsuario = new Usuario();
            novoUsuario.setSenha(passwordEncoder.encode(registerDTO.senha()));
            novoUsuario.setNome(registerDTO.nome());
            novoUsuario.setEmail(registerDTO.email());
            this.usuarioRepository.save(novoUsuario);

            String token = this.tokenService.gerarToken(novoUsuario);
            return ResponseEntity.ok(new ResponseLoginDTO(token, novoUsuario.getNome()));
        }

        return ResponseEntity.badRequest().build();
    }
}
