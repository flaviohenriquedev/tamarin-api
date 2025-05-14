package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.converter.PerfilMapper;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PerfilService extends DefaultServiceImpl<Perfil, PerfilDTO> {

    @Autowired
    private PerfilRepository repository;

    @Autowired
    private PerfilMapper mapper;

    @Override
    protected JpaRepository<Perfil, UUID> getRepository() {
        return repository;
    }

    @Override
    protected DtoMapper<Perfil, PerfilDTO> getMapper() {
        return mapper;
    }
}
