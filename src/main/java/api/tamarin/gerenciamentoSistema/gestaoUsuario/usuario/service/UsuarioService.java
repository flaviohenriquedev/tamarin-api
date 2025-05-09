package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.service;

import api.tamarin._root._infra.security.TokenService;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioRegister;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model.UsuarioCliente;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.service.UsuarioClienteService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.model.UsuarioClienteSistema;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.service.UsuarioClienteSistemaService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.model.UsuarioClienteSistemaPerfil;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.service.UsuarioClienteSistemaPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class UsuarioService extends DefaultServiceImpl<Usuario> {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuarioClienteService usuarioClienteService;

    @Autowired
    UsuarioClienteSistemaService usuarioClienteSistemaService;

    @Autowired
    UsuarioClienteSistemaPerfilService usuarioClienteSistemaPerfilService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenService tokenService;

    @Override
    protected JpaRepository<Usuario, UUID> getRepository() {
        return repository;
    }

    public ResponseEntity register(UsuarioRegister usuarioRegister) {

        if (!repository.existsByEmail(usuarioRegister.usuario().getEmail())) {
            usuarioRegister.usuario().setSenha(passwordEncoder.encode("12345"));
            Usuario usuario = this.repository.save(usuarioRegister.usuario());

            String token = tokenService.generateToken(usuario);
            usuario.setToken(token);

            if (!usuarioRegister.clientes().isEmpty() && !usuario.getUsuarioMaster()) {
                usuarioRegister.clientes().forEach(cliente -> {
                    UsuarioCliente usuarioCliente = new UsuarioCliente();
                    usuarioCliente.setUsuario(usuario);
                    usuarioCliente.setCliente(cliente);

                    UsuarioCliente usuarioClienteSalvo = usuarioClienteService.salvar(usuarioCliente);
                    if (!usuarioRegister.sistemasRoles().isEmpty()) {
                        for (Map<String, String> sistema : usuarioRegister.sistemasRoles()) {
                            for (Map.Entry<String, String> entry : sistema.entrySet()) {
                                String keySistema = entry.getKey();
                                String role = entry.getValue();

                                UsuarioClienteSistema usuarioClienteSistema = new UsuarioClienteSistema();
                                usuarioClienteSistema.setUsuarioCliente(usuarioClienteSalvo);
                                usuarioClienteSistema.setSistema(keySistema);
                                usuarioClienteSistema.setRole(role);

                                UsuarioClienteSistema usuarioClienteSistemaSalvo = usuarioClienteSistemaService.salvar(usuarioClienteSistema);
                                if (!usuarioRegister.perfis().isEmpty()) {
                                    usuarioRegister.perfis().forEach(perfil -> {
                                        UsuarioClienteSistemaPerfil usuarioClienteSistemaPerfil = new UsuarioClienteSistemaPerfil();
                                        usuarioClienteSistemaPerfil.setUsuarioClienteSistema(usuarioClienteSistemaSalvo);
                                        usuarioClienteSistemaPerfil.setPerfil(perfil);

                                        usuarioClienteSistemaPerfilService.salvar(usuarioClienteSistemaPerfil);
                                    });
                                }
                            }
                        }
                    }
                });
            }
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.badRequest().build();
    }
}