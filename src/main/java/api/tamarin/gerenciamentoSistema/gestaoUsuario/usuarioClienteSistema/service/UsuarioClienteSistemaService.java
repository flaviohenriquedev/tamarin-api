package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.model.UsuarioClienteSistema;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.repository.UsuarioClienteSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioClienteSistemaService extends DefaultServiceImpl<UsuarioClienteSistema> {

    @Autowired
    UsuarioClienteSistemaRepository usuarioClienteSistemaRepository;

    @Override
    protected JpaRepository<UsuarioClienteSistema, UUID> getRepository() {
        return usuarioClienteSistemaRepository;
    }
}
