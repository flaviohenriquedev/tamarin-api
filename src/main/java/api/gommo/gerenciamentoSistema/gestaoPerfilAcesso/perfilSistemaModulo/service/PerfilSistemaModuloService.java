package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.service;

import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.dto.PerfilSistemaModuloDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.model.PerfilSistemaModulo;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.repository.PerfilSistemaModuloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class PerfilSistemaModuloService extends DefaultServiceImpl<PerfilSistemaModulo, PerfilSistemaModuloDTO> {

    @Autowired
    private PerfilSistemaModuloRepository perfilSistemaModuloRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<PerfilSistemaModulo, UUID> getRepository() {
        return perfilSistemaModuloRepository;
    }

    @Override
    protected DtoMapper<PerfilSistemaModulo, PerfilSistemaModuloDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, PerfilSistemaModulo.class, PerfilSistemaModuloDTO.class);
    }

    public Set<PerfilSistemaModuloDTO> findByPerfilSistemaId(UUID idPerfilSistema) {
        List<PerfilSistemaModulo> listaModulos = perfilSistemaModuloRepository.findByPerfilSistemaId(idPerfilSistema);
        return listaModulos.isEmpty() ? Set.of() : new HashSet<>(getMapper().toDtoList(listaModulos));
    }
}
