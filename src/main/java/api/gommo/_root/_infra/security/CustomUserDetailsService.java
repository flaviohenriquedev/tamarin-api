package api.gommo._root._infra.security;

import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado -> " + username));
        return new User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>());
    }
}
