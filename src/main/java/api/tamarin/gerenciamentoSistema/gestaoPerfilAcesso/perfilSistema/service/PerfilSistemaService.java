package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model.PerfilSistema;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.repository.PerfilSistemaRepository;
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
    protected JpaRepository<PerfilSistema, UUID> getPerfilRepository() {
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
