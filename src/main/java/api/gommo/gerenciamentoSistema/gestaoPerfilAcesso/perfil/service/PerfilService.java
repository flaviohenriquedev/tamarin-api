package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service;

import api.gommo._root.comum.enums.SistemaENUM;
import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.repository.PerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PerfilService extends DefaultServiceImpl<Perfil, PerfilDTO> {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected DefaultRepository<Perfil, UUID> getRepository() {
        return perfilRepository;
    }

    @Override
    protected DtoMapper<Perfil, PerfilDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Perfil.class, PerfilDTO.class);
    }

    public List<PerfilDTO> listarPerfisPorSistema(SistemaENUM sistema) {
        return getMapper().toDtoList(perfilRepository.getBySistema(sistema));
    }

    @Override
    public PerfilDTO salvar(PerfilDTO perfil) {
        if (!perfil.getPerfilModulos().isEmpty()) {
            perfil.getPerfilModulos().forEach(perfilModulo -> {
                perfilModulo.setPerfil(perfil);
            });
        }
        return super.salvar(perfil);
    }

    public PerfilDTO findById(UUID perfilId) {
        Perfil perfil = perfilRepository.findById(perfilId)
                .orElseThrow(() -> new IllegalArgumentException("Perfil não encontrado: " + perfilId));
        return getMapper().toDto(perfil);
    }
}
