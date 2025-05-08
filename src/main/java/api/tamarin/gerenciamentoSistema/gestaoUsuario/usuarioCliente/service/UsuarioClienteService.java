package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model.UsuarioCliente;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.repository.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioClienteService extends DefaultServiceImpl<UsuarioCliente> {

    @Autowired
    UsuarioClienteRepository usuarioClienteRepository;

    @Override
    protected JpaRepository<UsuarioCliente, UUID> getRepository() {
        return usuarioClienteRepository;
    }
}
