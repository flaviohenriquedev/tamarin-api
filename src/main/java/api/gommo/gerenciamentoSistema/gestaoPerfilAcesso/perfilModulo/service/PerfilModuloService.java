package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.dto.PerfilModuloDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.model.PerfilModulo;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.repository.PerfilModuloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PerfilModuloService extends DefaultServiceImpl<PerfilModulo, PerfilModuloDTO> {

    @Autowired
    private PerfilModuloRepository perfilModuloRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<PerfilModulo, UUID> getRepository() {
        return perfilModuloRepository;
    }

    @Override
    protected DtoMapper<PerfilModulo, PerfilModuloDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, PerfilModulo.class, PerfilModuloDTO.class);
    }
}
