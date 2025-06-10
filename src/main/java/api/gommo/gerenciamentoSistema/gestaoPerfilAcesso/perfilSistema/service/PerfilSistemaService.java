package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model.PerfilSistema;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.repository.PerfilSistemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PerfilSistemaService extends DefaultServiceImpl<PerfilSistema, PerfilSistemaDTO> {

    @Autowired
    private PerfilSistemaRepository perfilSistemaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<PerfilSistema, UUID> getRepository() {
        return perfilSistemaRepository;
    }

    @Override
    protected DtoMapper<PerfilSistema, PerfilSistemaDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, PerfilSistema.class, PerfilSistemaDTO.class);
    }

    public List<PerfilSistemaDTO> listarPorIdPerfil(UUID id) {
        return getMapper().toDtoList(perfilSistemaRepository.findByPerfilId(id));
    }
}
