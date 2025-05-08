package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.model.UsuarioClienteSistemaPerfil;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.repository.UsuarioClienteSistemaPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioClienteSistemaPerfilService extends DefaultServiceImpl<UsuarioClienteSistemaPerfil> {

    @Autowired
    UsuarioClienteSistemaPerfilRepository usuarioClienteSistemaPerfilRepository;

    @Override
    protected JpaRepository<UsuarioClienteSistemaPerfil, UUID> getRepository() {
        return usuarioClienteSistemaPerfilRepository;
    }
}
