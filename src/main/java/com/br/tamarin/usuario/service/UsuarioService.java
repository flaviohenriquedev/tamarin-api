package com.br.tamarin.usuario.service;

import com.br.tamarin.root.repository.CRUDRepository;
import com.br.tamarin.root.service.impl.ServiceImpl;
import com.br.tamarin.usuario.entity.Usuario;
import com.br.tamarin.usuario.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService extends ServiceImpl<Usuario> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected CRUDRepository<Usuario, UUID> getRepository() {
        return repository;
    }

    @Override
    public void salvar(Usuario usuario) {

        Optional<Usuario> usuarioRetorno = this.repository.findByEmail(usuario.getEmail());

        if (usuarioRetorno.isEmpty()) {
            String novaSenha = usuario.getCpf().substring(0, 5);
            Usuario novoUsuario = new Usuario();
            BeanUtils.copyProperties(usuario, novoUsuario);
            novoUsuario.setSenha(passwordEncoder.encode(novaSenha));
            this.usuarioRepository.save(novoUsuario);
        }
    }
}
